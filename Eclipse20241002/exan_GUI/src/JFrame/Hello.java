package JFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Hello extends JFrame implements ActionListener {
	JButton b;
	JTextField t;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gui app = new Gui("test");
	}

	public Hello(String str) {
		super(str);
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());

		b = new JButton("press me");
		b.setActionCommand("on");
		b.addActionListener(this);

		t = new JTextField(10);
		t.addActionListener(this);

		c.add(b);
		c.add(t);

		this.setSize(200, 200);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == b) {
			if (event.getActionCommand() == "on") {
				System.out.println("on");
				((JButton) event.getSource()).setActionCommand("off");
			} else {
				System.out.println("off");
				((JButton) event.getSource()).setActionCommand("on");
			}
		} else if (event.getSource() == t) {
			System.out.println(event.getActionCommand());
		}

	}
}

class Gui extends JFrame implements ActionListener, WindowListener
{
	public Gui(String str) {
		super(str);
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = this.getContentPane();
		

		JButton b = new JButton("press me");
		c.add(b);
		b.addActionListener(this);
		addWindowListener(this);
		
		this.setSize(200, 200);
		this.setLocation(300, 300);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		final String bell = "띵띵띵";
		if(event.getActionCommand().equals("press me"))
		{
			System.out.println(bell);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
