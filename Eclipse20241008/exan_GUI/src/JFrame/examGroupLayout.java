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

public class examGroupLayout extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		examGroupLayout app = new examGroupLayout("title");
	}

	public examGroupLayout(String s) {
		super(s);
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
	
		Container c = getContentPane();
		GroupLayout layout = new GroupLayout(c);
		c.setLayout(layout);

		JButton b1 = new JButton("Button1");
		JButton b2 = new JButton("Button2");
		JButton b3 = new JButton("Button3");
		JButton b4 = new JButton("Button4");
		JButton b5 = new JButton("Button5");
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup().addComponent(b1, 0, GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(b2)
						.addComponent(b4))
				.addComponent(b3));
				
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(b1)
							.addComponent(b2)
							.addComponent(b3))
					.addComponent(b4));
				
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		pack();
		

		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}
}
