package JFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PanelDemo extends JFrame implements ActionListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PanelDemo app = new PanelDemo("hello");
	}

	public PanelDemo(String str) {
		super(str);
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		c.setBackground(Color.yellow);
		c.setLayout(new FlowLayout());

		JButton b = new JButton("press me");
		c.add(b);

		
		b.addActionListener(this);

		this.setSize(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300, 300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		final char bell = '\u0007';
		if (event.getActionCommand().equals("press me")) {
			System.out.println(bell);
		}
	}
}

