package GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginExam extends JFrame {

	private JLabel login, pass;
	private JTextField text1;
	private JPasswordField password;
	private JButton ok, cancel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginExam app = new LoginExam();
	}

	public LoginExam() {
		super("Login");
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 2));

		login = new JLabel("login : ");
		pass = new JLabel("passowrd : ");
		text1 = new JTextField(10);
		password = new JPasswordField();
		ok = new JButton("ok");
		cancel = new JButton("cancel");

		c.add(login);
		c.add(text1);
		c.add(pass);
		c.add(password);
		c.add(ok);
		c.add(cancel);

		TextFieldHandler tf_handler = new TextFieldHandler();
		text1.addActionListener(tf_handler);
		password.addActionListener(tf_handler);
		
		JButtonHandler jh_handler = new JButtonHandler();
		ok.addActionListener(jh_handler);
		cancel.addActionListener(jh_handler);
				
		setSize(200, 200);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class TextFieldHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == text1) {
				password.requestFocus();
			}
			if (e.getSource() == password) {
				ok.doClick();
			}

		}
	}
	
	private class JButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String s = "";
			
			if(e.getSource() == ok)
			{
				if(text1.getText().equals("bmkim") && new String(password.getPassword()).equals("bmkim"))
					s = "축하합니다.";
				else
					s = "틀렸습니다. 다시 입력해주세요.";
			}
			else if(e.getSource() == cancel)
			{
				text1.setText("");
				password.setText("");
				return;
			}
			JOptionPane.showMessageDialog(null, s);
		}
		
	}
}

