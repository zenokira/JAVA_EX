package Dialog;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ColorChooseDemo extends JFrame {
	JLabel testLabel;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorChooseDemo app = new ColorChooseDemo("Test");
	}
	
	public ColorChooseDemo(String s)
	{
		super(s);
		initializeComponents();
	}

	private void initializeComponents()
	{
		Container c = getContentPane();
		
		testLabel = new JLabel();
		c.add(testLabel);
		testLabel.setBackground(Color.YELLOW);
		testLabel.setOpaque(true);
		
		setSize(500, 500);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
