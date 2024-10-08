package JFrame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class examMultiLayout extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		examMultiLayout start = new examMultiLayout("test");
	}

	public examMultiLayout(String s) {
		super(s);
		initializeComponents();
	}

	private void initializeComponents() {
		Container c = getContentPane();
		
		BoxLayout layout = new BoxLayout(c,BoxLayout.Y_AXIS);
		c.setLayout(layout);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		c.add(p1);
		c.add(Box.createRigidArea(new Dimension(0,5)));
		c.add(p2);
		
		JButton btn;
		
		p1.setLayout(new GridLayout(1,3,5,5));
		for(int i = 1; i <=3; i++)
		{
			btn = new JButton(Integer.toString(i));
			p1.add(btn);
		}

		p2.setLayout(new BoxLayout(p2,BoxLayout.X_AXIS));
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p2.add(p3);
		p2.add(Box.createRigidArea(new Dimension(5,0)));
		p2.add(p4);
		
		p3.setLayout(new GridLayout(4,3,5,5));
		for(int i = 4; i <= 15; i++)
		{	
			btn = new JButton(Integer.toString(i));
			p3.add(btn);
		}
		
		p4.setLayout(new GridLayout(5,1,5,5));
		for(int i = 16; i <= 20; i++)
		{
			btn = new JButton(Integer.toString(i));
			p4.add(btn);
		}
		
		pack();
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
