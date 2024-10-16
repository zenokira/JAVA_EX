package 빙고복권;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class 빙고복권 extends JFrame implements ActionListener, ItemListener {

	private final int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private boolean[] flag = new boolean[9];
	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	private JButton[] clckBtn = new JButton[9];
	private JButton rgBtn;
	private JTextField edit;
	private int money = 600;

	private Random rand = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		빙고복권 start = new 빙고복권();
	}

	public 빙고복권() {
		super("복권빙고!!");
		Initialize();
		initializeComponents();
//		reset();
	}

	private void Initialize()
	{
		map.put(6, 10000);		map.put(7, 36);
		map.put(8, 720);		map.put(9, 360);
		map.put(10, 80);		map.put(11, 252);
		map.put(12, 108);		map.put(13, 72);
		map.put(14, 54);		map.put(15, 180);
		map.put(16, 72);		map.put(17, 180);
		map.put(18, 119);		map.put(19, 36);
		map.put(20, 306);		map.put(21, 1080);
		map.put(22, 144);		map.put(23, 1800);
		map.put(24, 3600);
	}
	private void initializeComponents() {
		
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
				
		JPanel lp = new JPanel();
		JPanel rp = new JPanel();
				
		lp.setLayout(new GridLayout(3,1));
		rp.setLayout(new GridBagLayout());
						
		c.add(lp);
		c.add(rp);
		
		JPanel lp_up = new JPanel(new GridLayout(2,1));
		JPanel lp_center = new JPanel();
		JPanel lp_down = new JPanel();

		lp.add(lp_up);
		lp.add(lp_center);
		lp.add(lp_down);
		
		JLabel head1 = new JLabel("<< 보상 >>");
		head1.setHorizontalAlignment(JLabel.CENTER);
		JLabel head2 = new JLabel("점수 : 판돈");
		head2.setPreferredSize(getPreferredSize());
		head2.setHorizontalAlignment(JLabel.CENTER);
		JLabel rewardlist = new JLabel();
		rewardlist.setHorizontalAlignment(JLabel.CENTER);
		JLabel label1 = new JLabel("내 돈 : ");
		JLabel label2 = new JLabel("만원");
		
		
		edit = new JTextField("600");
		edit.setEditable(false);
		JLabel label3 = new JLabel();

		StringBuilder str_reward = new StringBuilder();
		str_reward.append("<html><body><center>");
		int cnt = 0;
		for( HashMap.Entry<Integer, Integer> entry : map.entrySet() ){
			int Key = entry.getKey();
			int Value = entry.getValue();
			int lenKey = Integer.toString(Key).length();
			int lenValue = Integer.toString(Value).length();
			
			while(lenKey < 2)
			{
				str_reward.append("&ensp;");
				lenKey++;
			}
			
			str_reward.append(Key + "&nbsp;:&nbsp;");
			
			while(lenValue < 5+2)
			{
				str_reward.append("&ensp;");
				lenValue++;
			}
			
			str_reward.append(Value);
		  
			cnt++;
			
		    if(cnt % 2 == 0) str_reward.append( "<br>");
		    else str_reward .append("&emsp;");
		}
		str_reward.append("</center></body></html>");
		rewardlist.setText(str_reward.toString());
		
		head1.setFont(head1.getFont().deriveFont(20.0f));
		rewardlist.setFont(rewardlist.getFont().deriveFont(20.0f));
		label1.setFont(label1.getFont().deriveFont(30.0f));
		label2.setFont(label2.getFont().deriveFont(30.0f));
		label3.setFont(label3.getFont().deriveFont(30.0f));
		
		lp_up.add(head1);
		lp_up.add(head2);
		lp_center.add(rewardlist);
		lp_down.add(label1);
		lp_down.add(edit);
		lp_down.add(label2);
		lp_down.add(label3);

		GridBagConstraints r_c = new GridBagConstraints();
	
		r_c.insets = new Insets(0,10,10,0); 
		int gridy = 0;
		for (int i = 0; i < 9; i++) {
			r_c.gridx = i%3;
			r_c.gridy = gridy;
			clckBtn[i] = new JButton();
			rp.add(clckBtn[i]);
			clckBtn[i].addActionListener(this);
			if(i%3 == 0 ) gridy++;
		}
		
		rgBtn = new JButton("다시 시작");
		rp.add(rgBtn);
		rgBtn.addActionListener(this);
		
	

		pack();
		this.setSize(600, 500);
		setLocation(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton btn = (JButton) e.getSource();

		if (!btn.isEnabled())
			return;

		if (btn.getText().equals("다시 시작")) {
			reset();

		} else {

			while (true) {
				int idx = rand.nextInt(9);
				if (!isNumUse(idx)) {
					btn.setText(Integer.toString(num[idx]));
					flag[idx] = true;
					break;
				}
			}

			btn.setEnabled(false);
		}

		if (getUseBtnCnt() == 3 || getUseBtnCnt() == 4) {
			if (isBingo()) {
				int jumsu = getBingoSum();
				int coin = map.get(jumsu);
				money += coin;
				edit.setText(Integer.toString(money));
				String s = String.format("%d점 입니다!\n%d 만원을 얻으셨습니다!", jumsu, coin);
				JOptionPane.showMessageDialog(null, s);
				reset();
			} else if (!isBingo() && getUseBtnCnt() == 4) {
				JOptionPane.showMessageDialog(null, "빙고를 만들지 못했습니다!!");
				reset();
			}
		}

	}

	private void reset() {
		Arrays.fill(flag, false);
		for (int i = 0; i < 9; i++) {
			clckBtn[i].setText("");
			clckBtn[i].setEnabled(true);
		}

		int n = JOptionPane.showConfirmDialog(null, "최대 클릭 3번의 기회!!\n200만원을 지불하여 게임을 시작하시겠습니까?", "복권사기",
				JOptionPane.YES_NO_OPTION);

		if (n == 0) {
			money -= 200;
			int idx1 = rand.nextInt(9);
			int idx2 = rand.nextInt(9);
			clckBtn[idx1].setEnabled(false);
			clckBtn[idx1].setText(Integer.toString(num[idx2]));
			flag[idx2] = true;
			edit.setText(Integer.toString(money));
		}

	}

	private boolean isNumUse(int _idx) {
		return flag[_idx];
	}

	private int getUseBtnCnt() {
		int n = 0;
		for (int i = 0; i < 9; i++) {
			if (flag[i])
				n++;
		}
		return n;
	}

	private int getBingoSum() {
		int sum = 0;

		for (int i = 0; i < 9; i++) {

			if (isColBingo(i))
				sum = parseInt(clckBtn[i]) + parseInt(clckBtn[i + 1]) + parseInt(clckBtn[i + 2]);

			else if (isRowBingo(i))
				sum = parseInt(clckBtn[i]) + parseInt(clckBtn[i + 3]) + parseInt(clckBtn[i + 6]);

			else if (isDiaBingo(i)) {
				sum = parseInt(clckBtn[i]) + parseInt(clckBtn[i + 4]) + parseInt(clckBtn[i + 8]);
			}

		}
		return sum;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	private boolean isBingo() {
		for (int i = 0; i < 9; i++) {
			if (isColBingo(i) || isRowBingo(i) || isDiaBingo(i))
				return true;
		}
		return false;
	}

	private int parseInt(JButton btn) {
		return Integer.parseInt(btn.getText());
	}

	private boolean isColBingo(int i) {
		if (i % 3 != 0)
			return false;
		return !clckBtn[i].isEnabled() && !clckBtn[i + 1].isEnabled() && !clckBtn[i + 2].isEnabled();
	}

	private boolean isRowBingo(int i) {
		if (i >= 3)
			return false;
		return !clckBtn[i].isEnabled() && !clckBtn[i + 3].isEnabled() && !clckBtn[i + 6].isEnabled();
	}

	private boolean isDiaBingo(int i) {
		if (i == 0)
			return !clckBtn[i].isEnabled() && !clckBtn[i + 4].isEnabled() && !clckBtn[i + 8].isEnabled();

		else if (i == 2)
			return !clckBtn[i].isEnabled() && !clckBtn[i + 2].isEnabled() && !clckBtn[i + 4].isEnabled();

		else
			return false;
	}
}