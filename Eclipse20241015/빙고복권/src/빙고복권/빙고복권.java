package 빙고복권;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class 빙고복권 extends JFrame implements ActionListener, ItemListener {

	private final int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	private boolean[] flag = new boolean[9];
	private JButton[] clckBtn = new JButton[9];
	private JButton rgBtn;
	private JTextField edit;
	private int total = 600;
	private LinkedList<Integer> ll_UseBtnIdx = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		빙고복권 start = new 빙고복권();
	}

	public 빙고복권() {
		super("복권빙고!!");
		initializeComponents();
		
		map.put(6, 10000);	map.put(7, 36);
		map.put(8, 720);	map.put(9, 360);
		map.put(10, 80);	map.put(11, 252);
		map.put(12, 108);	map.put(13, 72);
		map.put(14, 54);	map.put(15, 180);
		map.put(16, 72);	map.put(17, 180);
		map.put(18, 119);	map.put(19, 36);
		map.put(20, 306);	map.put(21, 1080);
		map.put(22, 144);	map.put(23, 1800);
		map.put(24, 3600);	
		
		reset();
	}

	private void initializeComponents() {
		Container c = getContentPane();

		BoxLayout layout = new BoxLayout(c, BoxLayout.Y_AXIS);
		c.setLayout(layout);

		JPanel panel1 = new JPanel();
		c.add(panel1);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

		JPanel lp = new JPanel();
		JPanel rp = new JPanel();

		panel1.add(lp);
		panel1.add(rp);

		lp.setLayout(new BoxLayout(lp, BoxLayout.Y_AXIS));
		rp.setLayout(new BoxLayout(rp, BoxLayout.Y_AXIS));

		JPanel lp_up = new JPanel(new GridLayout());
		JPanel lp_center = new JPanel(new GridLayout());
		JPanel lp_down = new JPanel(new GridLayout(1, 3, 5, 5));

		lp.add(lp_up);
		lp.add(lp_center);
		lp.add(lp_down);

		Label head = new Label("<< 보상 >>");
		Label rewardlist = new Label();
		Label label1 = new Label("내 돈 : ");
		edit = new JTextField("600");
		edit.setEditable(false);
		Label label2 = new Label("만원");

		lp_up.add(head);
		lp_center.add(rewardlist);
		lp_down.add(label1);
		lp_down.add(edit);
		lp_down.add(label2);

		JPanel rp_up = new JPanel(new GridLayout());
		JPanel rp_center = new JPanel(new GridLayout(3, 3, 5, 5));
		JPanel rp_down = new JPanel(new GridLayout());

		rp.add(rp_up);
		rp.add(rp_center);
		rp.add(rp_down);

		for (int i = 0; i < 9; i++) {
			clckBtn[i] = new JButton();
			rp_center.add(clckBtn[i]);
			clckBtn[i].addActionListener(this);
		}

		pack();
		setSize(600, 400);
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

		if (btn.getText().equals("다시시작")) {
			reset();
			
		} else {
			Random rd = new Random();

			while (true) {
				int idx = rd.nextInt(9);
				if (!isNumUse(idx)) {
					btn.setText(Integer.toString(num[idx]));
					flag[idx] = true;
					ll_UseBtnIdx.add(idx);
					Collections.sort(ll_UseBtnIdx);
					break;
				}
			}

			btn.setEnabled(false);
		}
		
		if(getUseBtnCnt() >= 3 && getUseBtnCnt() <= 4)
		{
			if(isBingo())
			{
				
			}
			total += map.get(getBingoSum());
			edit.setText(Integer.toString(total));
		}
	}

	private void reset() {
		Arrays.fill(flag, false);
		for (int i = 0; i < 9; i++)
			clckBtn[i].setText("");
		ll_UseBtnIdx.clear();
	}

	private boolean isNumUse(int _idx) {
		return flag[_idx];
	}
	
	private int getUseBtnCnt()
	{
		return ll_UseBtnIdx.size();
	}
	
	private int getBingoSum()
	{
		int sum = 0;
		
		for(int i : ll_UseBtnIdx)
		{
			if(isColBingo(i))
				sum = parseInt(clckBtn[i]) + parseInt(clckBtn[i+1]) + parseInt(clckBtn[i+2]);
			
			else if(isRowBingo(i))
				sum = parseInt(clckBtn[i]) + parseInt(clckBtn[i+3]) + parseInt(clckBtn[i+6]);
			
			else if(isDiaBingo(i))
			{
				sum = parseInt(clckBtn[i]) + parseInt(clckBtn[i+4]) + parseInt(clckBtn[i+8]);
			}
			
		}
		return sum;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private boolean isBingo()
	{
		for(int n : ll_UseBtnIdx)
		{
			if(isColBingo(n) || isRowBingo(n) || isDiaBingo(n)) 
				return true;
		}
		return false;
	}
	
	private int parseInt(JButton btn)
	{
		return Integer.parseInt(btn.getText());
	}
	
	private boolean isColBingo(int i)
	{
		if(i % 3 != 0) return false;
		return flag[i] && flag[i+1] && flag[i+2];
	}
	private boolean isRowBingo(int i)
	{
		if(i >= 3) return false;
		return flag[i] && flag[i+3] && flag[i+6];
	}
	private boolean isDiaBingo(int i)
	{
		if(i == 0)	return flag[i] && flag[i+4] && flag[i+8];
		else if( i == 2) return flag[i] && flag[i+2] && flag[i+4];
		else return false;
	}
}