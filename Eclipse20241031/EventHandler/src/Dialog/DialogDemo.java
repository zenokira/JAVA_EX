package Dialog;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DialogDemo extends JFrame implements ActionListener{

	JButton test;
	JTextField textbox;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DialogDemo app = new DialogDemo();
	}

	public DialogDemo()
	{
		super("test");
		initializeComponets();
	}
	
	private void initializeComponets() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		test = new JButton("test");
		test.addActionListener(this);
		c.add(test);
		textbox = new JTextField(10);
		c.add(textbox);
		
		pack();
		setLocation(300, 300);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String s = JOptionPane.showInputDialog("주소를 입력하세요");
		textbox.setText(s);
	}

}


class SearchDialog extends JDialog implements ActionListener{
	
	
	private JLabel label = new JLabel("Find");
	private JTextField searchTextField = new JTextField(20);
	private JButton okButton = new JButton("OK");

	public SearchDialog(JFrame frame)
	{
		super(frame, "find dialog");
		setLayout(new FlowLayout());
		add(label);
		add(searchTextField);
		add(okButton);
		
		pack();
		okButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
	}
	
	public String getInputString()
	{
		if(searchTextField.getText().length() == 0) return null;
		else return searchTextField.getText();
	}
	public void setInputString(String s)
	{
		searchTextField.setText(s);
	}
}