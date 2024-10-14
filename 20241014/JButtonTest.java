package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JButtonTest extends JFrame implements ActionListener{

	private JButton button, imageButton;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JButtonTest app = new JButtonTest();
	}

	
	public JButtonTest()
	{
		super("test");
		initializeComponents();
	}


	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		button = new JButton("일반버튼");
		button.addActionListener(this);
		c.add(button);
		
		Icon bug1 = new ImageIcon("icon1.png");
		Icon bug2 = new ImageIcon("icon2.png");
		imageButton = new JButton("이미지버튼",bug1);
		imageButton.addActionListener(this);
		imageButton.setRolloverIcon(bug2);
		c.add(imageButton);
				
		setSize(800,800);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null, button.getText() + " 버튼을 눌렀습니다");
	}
}
