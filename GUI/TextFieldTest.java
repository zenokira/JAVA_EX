package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextFieldTest extends JFrame implements ActionListener {
	
	private JTextField text1, text2, text3;
	private JPasswordField password;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextFieldTest app = new TextFieldTest();
	}

	
	public TextFieldTest()
	{
		super("test");
		initializeComponents();
	}


	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		text1 = new JTextField("문자 입력");
		c.add(text1);
		text2 = new JTextField("20");
		c.add(text2);
		text3 = new JTextField("문자 입력 불가능");
		text3.setEditable(false);
		c.add(text3);
		
		password = new JPasswordField("패스워드");
		c.add(password);
		
		text1.addActionListener(this);
		text2.addActionListener(this);
		text3.addActionListener(this);
		password.addActionListener(this);
		
		
		setSize(800,800);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String s ="";
		
		if( e.getSource() == text1)
			s = "text1 : " + text1.getText();
		else if( e.getSource() == text2)
			s = "text2 : " + text2.getText();
		else if( e.getSource() == text3)
			s = "text3 : " + text3.getText();
		else if( e.getSource() == password)
		{
			JPasswordField pwd = (JPasswordField) e.getSource();
			s = "password : " + new String(pwd.getPassword());
		}
		JOptionPane.showMessageDialog(null, s);
	}
}
