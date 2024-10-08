package JFrame;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class examSpringLayout extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		examSpringLayout app = new examSpringLayout("title");
	}

	public examSpringLayout(String s) {
		super(s);
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		
		Container c = getContentPane();
		
		SpringLayout layout = new SpringLayout();
		c.setLayout(layout);

	
		Component left = new JLabel("Left"); c.add(left);
		Component right = new JTextField(15); c.add(right);
		
		
		layout.putConstraint(SpringLayout.WEST, left, 10, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, left, 25, SpringLayout.NORTH, c);
		layout.putConstraint(SpringLayout.NORTH, right, 25, SpringLayout.NORTH, c);
		layout.putConstraint(SpringLayout.WEST, right, 20, SpringLayout.EAST, left);
		layout.putConstraint(SpringLayout.EAST, c, 20, SpringLayout.EAST, right);
		
		this.setSize(300,200);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}
}
