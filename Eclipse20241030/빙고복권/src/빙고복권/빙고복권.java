package 빙고복권;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class 빙고복권 extends JFrame implements ActionListener {

	private ArrayList<Integer> Num = new ArrayList<Integer>();
	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	Queue<MyButton> q = new LinkedList<MyButton>();
	private MyButton[][] clckBtn = new MyButton[3][3];
	private JButton rgBtn;
	private JTextField edit;
	private int money = 600;
	private boolean gameflag = false;
	private int clckCnt = 0;
	private int jumsu = 0;

	private Random rand = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		빙고복권 start = new 빙고복권();
	}

	public 빙고복권() {
		super("복권빙고!!");
		Initialize();
		initializeComponents();
		reset();
		gameStart();
	}

	private void gameStart() {
		int n = JOptionPane.showConfirmDialog(null, "최대 클릭 3번의 기회!!\n200만원을 지불하여 게임을 시작하시겠습니까?", "복권사기",
				JOptionPane.YES_NO_OPTION);
		if (n == 0) {
			if (money >= 200) {
				money -= 200;
				gameflag = true;
				setRandBtnSelect();
			} else {
				String str = "돈이 부족합니다! 도박은 하지맙시다.\n공익광고캠페인\n지우고 다시설치해주세요.";
				JOptionPane.showMessageDialog(null, str);
				System.exit(0);
			}
		} else {
			gameflag = false;
			return;
		}
	}

	private void Initialize() {
		gameflag = false;
		money = 600;
		clckCnt = 0;
		jumsu = 0;

		map.put(6, 10000);
		map.put(7, 36);
		map.put(8, 720);
		map.put(9, 360);
		map.put(10, 80);
		map.put(11, 252);
		map.put(12, 108);
		map.put(13, 72);
		map.put(14, 54);
		map.put(15, 180);
		map.put(16, 72);
		map.put(17, 180);
		map.put(18, 119);
		map.put(19, 36);
		map.put(20, 306);
		map.put(21, 1080);
		map.put(22, 144);
		map.put(23, 1800);
		map.put(24, 3600);
	}

	private void resetNum() {
		Num.clear();
		for (int i = 1; i <= 9; i++) {
			Num.add(i);
		}
		// Collections.shuffle(Num);

		shuffle(Num);
	}

	private void shuffle(ArrayList<Integer> num) {
		int len = num.size();
		for (int k = 0; k < len; k++)
			for (int n = 0; n < len; n++) {
				int i = rand.nextInt(len);
				int j = rand.nextInt(len);

				int temp = num.get(i);
				num.set(i, num.get(j));
				num.set(j, temp);
			}
	}

	private void initializeComponents() {

		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 2));

		JPanel lp = new JPanel(new GridBagLayout());
		JPanel rp = new JPanel(new GridBagLayout());

		c.add(lp);
		c.add(rp);

		setLP(lp);
		setRP(rp);

		pack();
		this.setSize(600, 500);
		setResizable(false);
		setLocation(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		if (!((JButton)e.getSource()).isEnabled())
			return;

		if (e.getSource() instanceof MyButton) {
			if (gameflag == false)
				return;
			MyButton btn = (MyButton)e.getSource();
			clckCnt++;
			btn.setText();
			btn.setEnabled(false);
		} else {
			reStart();
			return;
		}

		if (isEnd()) {
			if (isBingo()) {
				bingo();
			} else if (!isBingo() && clckCnt == 3) {
				JOptionPane.showMessageDialog(null, "빙고를 만들지 못했습니다!!");
				gameflag = false;
			}
		}
	}

	private void reStart() {
		reset();
		gameStart();
	}

	private boolean isEnd() {
		return clckCnt == 2 || clckCnt == 3;
	}

	private void bingo() {
		int coin = map.get(jumsu);
		money += coin;
		edit.setText(Integer.toString(money));
		String s = String.format("%d점 입니다!\n%d 만원을 얻으셨습니다!", jumsu, coin);
		JOptionPane.showMessageDialog(null, s);
		gameflag = false;
	}

	private void setLP(JPanel lp) {
		JPanel lp_up = new JPanel(new GridBagLayout());
		JPanel lp_center = new JPanel();
		JPanel lp_down = new JPanel();

		addComponent(lp, 0, 0, lp_up);
		addComponent(lp, 0, 1, lp_center);
		addComponent(lp, 0, 2, lp_down);

		JLabel head1 = new JLabel("<< 보상 >>");
		JLabel head2 = new JLabel("점수 : 보상금");

		head1.setHorizontalAlignment(JLabel.CENTER);
		head2.setHorizontalAlignment(JLabel.CENTER);

		addComponent(lp_up, 0, 0, head1);
		addComponent(lp_up, 0, 1, head2);

		JLabel rewardlist = new JLabel();
		rewardlist.setHorizontalAlignment(JLabel.CENTER);
		rewardlist.setText(setRewardString());
		lp_center.add(rewardlist);

		JLabel label1 = new JLabel("내 돈 : ");
		JLabel label2 = new JLabel("만원");

		edit = new JTextField(Integer.toString(money));
		edit.setHorizontalAlignment(JLabel.CENTER);
		Dimension d = new Dimension(edit.getPreferredSize());
		d.setSize(d.getWidth() * 4, d.getHeight() * 2);
		edit.setPreferredSize(d);
		edit.setEditable(false);

		addComponent(lp_down, 0, 0, label1);
		addComponent(lp_down, 1, 0, edit);
		addComponent(lp_down, 2, 0, label2);

		head1.setFont(head1.getFont().deriveFont(30.0f));
		head2.setFont(head1.getFont().deriveFont(20.0f));
		rewardlist.setFont(rewardlist.getFont().deriveFont(20.0f));
		edit.setFont(edit.getFont().deriveFont(30.0f));
		label1.setFont(label1.getFont().deriveFont(30.0f));
		label2.setFont(label2.getFont().deriveFont(30.0f));
	}

	private String setRewardString() {
		StringBuilder str = new StringBuilder();
		str.append("<html><body><center>");

		int cnt = 0;
		for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
			int Key = entry.getKey();
			int Value = entry.getValue();
			int lenKey = Integer.toString(Key).length();
			int lenValue = Integer.toString(Value).length();

			while (lenKey < 2) {
				str.append("&ensp;");
				lenKey++;
			}

			str.append(Key + "&nbsp;:&nbsp;");

			while (lenValue < 5 + 2) {
				str.append("&ensp;");
				lenValue++;
			}

			str.append(Value);

			cnt++;

			if (cnt % 2 == 0)
				str.append("<br>");
			else
				str.append("&emsp;");
		}
		str.append("</center></body></html>");

		return str.toString();
	}

	private void setRP(JPanel rp) {
		GridBagConstraints r_gbc = new GridBagConstraints();

		JPanel rp_main = new JPanel(new GridBagLayout());
		JPanel rp_sub = new JPanel(new FlowLayout());

		r_gbc.weighty = 0.3f;
		addComponent(rp, 0, 0, rp_main, r_gbc);
		r_gbc.weighty = 0.1f;
		addComponent(rp, 0, 1, rp_sub, r_gbc);

		Dimension dms_clckBtn = new Dimension();
		dms_clckBtn.setSize(80, 80);

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				clckBtn[y][x] = new MyButton();
				clckBtn[y][x].setPreferredSize(dms_clckBtn);
				addComponent(rp_main, x, y, clckBtn[y][x]);
				clckBtn[y][x].addActionListener(this);
			}
		}

		rgBtn = new JButton("다시 시작");
		Dimension dms_rgBtn = new Dimension(rgBtn.getPreferredSize());
		dms_rgBtn.setSize(dms_rgBtn.getWidth() * 2, dms_rgBtn.getHeight() + 50);
		rgBtn.setPreferredSize(dms_rgBtn);
		rp_sub.add(rgBtn);
		rgBtn.addActionListener(this);

	}

	private void addComponent(JPanel jp, int x, int y, Component src) {
		GridBagConstraints gbc = new GridBagConstraints();
		addComponent(jp, x, y, src, gbc);
	}

	private void addComponent(JPanel jp, int x, int y, Component src, GridBagConstraints gbc) {
		gbc.gridx = x;
		gbc.gridy = y;
		jp.add(src, gbc);
	}

	private void reset() {

		resetNum();
		jumsu = 0;
		clckCnt = 0;
		q.clear();
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				clckBtn[y][x].clear();
				clckBtn[y][x].setText();
				clckBtn[y][x].setEnabled(true);
				clckBtn[y][x].setIntNumber(Num.get(y * 3 + x));
			}
		}
	}

	private void setRandBtnSelect() {
		int idx = rand.nextInt(9);
		int y = idx / 3, x = idx % 3;
		clckBtn[y][x].setEnabled(false);
		clckBtn[y][x].setText();
		edit.setText(Integer.toString(money));
	}

	private boolean isBingo() {
		
		if (isColBingo())
			return true;
		if (isRowBingo())
			return true;
		if (isDiaBingo())
			return true;

		return false;
	}

	private boolean isColBingo() {
		int n = 3;

		for (int i = 0; i < n; i++) {
			jumsu = 0;
			int cnt = 0;
			for (int x = 0; x < n; x++) {
				if (!clckBtn[i][x].isEnabled()) {
					jumsu += clckBtn[i][x].getIntNumber();
					cnt++;
				}
			}
			if (cnt == n)
				return true;
		}
		return false;
	}

	private boolean isRowBingo() {
		int n = 3;
		for (int i = 0; i < n; i++) {
			jumsu = 0;
			int cnt = 0;
			for (int y = 0; y < n; y++) {
				if (!clckBtn[y][i].isEnabled()) {
					jumsu += clckBtn[y][i].getIntNumber();
					cnt++;
				}
			}
			if (cnt == n)
				return true;
		}
		return false;
	}

	private boolean isDiaBingo() {
		int n = 3;
		jumsu = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++)
			if (!clckBtn[i][i].isEnabled()) {
				jumsu += clckBtn[i][i].getIntNumber();
				cnt++;
			}

		if (cnt == n)
			return true;

		jumsu = 0;
		cnt = 0;
		for (int i = 0; i < n; i++)
			if (!clckBtn[i][n - 1 - i].isEnabled()) {
				jumsu += clckBtn[i][n - 1 - i].getIntNumber();
				cnt++;
			}

		if (cnt == n)
			return true;

		return false;
	}

}

class MyButton extends JButton {
	private int number = 0;

	public MyButton() {
		number = 0;
	}

	public boolean isNumberZero() {
		return number == 0;
	}

	public void clear() {
		number = 0;
	}

	public void setText() {
		if (number == 0)
			setText("");
		else
			setText(getStrNumber());
	}

	public String getStrNumber() {
		return Integer.toString(number);
	}

	public int getIntNumber() {
		return number;
	}

	public void setIntNumber(int number) {
		this.number = number;
	}
}