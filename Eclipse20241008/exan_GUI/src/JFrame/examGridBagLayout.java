package JFrame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

public class examGridBagLayout extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		examGridBagLayout app = new examGridBagLayout("title");
	}

	public examGridBagLayout(String s) {
		super(s);
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub

		JButton button;

		Container pane = getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		button = new JButton("버튼 1");

		c.weightx = 0.2;
		c.gridx = 0;
		c.gridy = 0;
		
		pane.add(button, c);

		button = new JButton("버튼 2");
		c.insets = new Insets(0,10,10,0);
		c.gridx = 1;
		c.gridy = 0;
		c.ipady = 20;
		pane.add(button, c);
		
		button = new JButton("버튼 3");
		
		c.gridx = 2; c.gridy = 0;
		pane.add(button, c);

		this.setSize(200, 200);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}
}
