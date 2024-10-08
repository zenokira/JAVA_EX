package JFrame;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class examNullLayout extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		examNullLayout start = new examNullLayout("test");
	}
	
	public examNullLayout(String s)
	{
		super(s);
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
	
		Container c = getContentPane();

		JButton button1 = new JButton("One");
		JButton button2 = new JButton("Two");
		JButton button3 = new JButton("Three");
		
		c.setLayout(null);
		
		c.add(button1);		
		c.add(button2);		
		c.add(button3);		
		
		button1.setBounds(30,50,100,20);
		button2.setBounds(30,80,100,20);
		button3.setBounds(150,50,100,20);
		
		this.setSize(500, 500);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
}
