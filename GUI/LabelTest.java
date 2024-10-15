package GUI;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelTest extends JFrame{

	private JLabel label1, label2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LabelTest app = new LabelTest();
	}

	
	public LabelTest()
	{
		super("test");
		initializeComponents();
	}


	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		label1 = new JLabel();
		label1.setText("문자열 캡션이 있는 레이블");
		label1.setToolTipText("단순 레이블");
		c.add(label1);
		
		Icon bug = new ImageIcon("icon1.png");
		label2 = new JLabel ("아이콘과 캡션이 있는 레이블", bug, SwingConstants.LEFT);
		
		label2.setToolTipText("아이콘 및 캡션 레이블");
		c.add(label2);
		
		setSize(800,800);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
