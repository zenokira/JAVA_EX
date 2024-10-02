package JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;

public class examFlowLayout extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		examFlowLayout app = new examFlowLayout("title");
	}
	
	public examFlowLayout(String s)
	{
		super(s);
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
	
		JButton[] buttons = new JButton[5];
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		for(int i = 0; i < 5; i++)
		{
			buttons[i] = new JButton("Button " + (i+1));
		}
		
		c.add(buttons[0], BorderLayout.EAST);
		c.add(buttons[1], BorderLayout.WEST);
		c.add(buttons[2], BorderLayout.SOUTH);
		c.add(buttons[3], BorderLayout.NORTH);
		c.add(buttons[4], BorderLayout.CENTER);

		
		
		this.setSize(200, 200);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
}
