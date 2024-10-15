package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JCheckBoxTest  extends JFrame implements ItemListener{
	
	private JTextField text;
	private JCheckBox bold, italic;
	int val1 = Font.PLAIN;
	int val2 = Font.PLAIN;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JCheckBoxTest app = new JCheckBoxTest();
	}

	
	public JCheckBoxTest()
	{
		super("test");
		initializeComponents();
	}


	private void initializeComponents() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		text = new JTextField("폰트 스타일 변경 예제", 30);
		text.setFont(new Font("TimesRoman", Font.PLAIN,12));
		c.add(text);
		
		bold = new JCheckBox("굵게");
		c.add(bold);
		
		italic = new JCheckBox("기울이게");
		c.add(italic);
		
		bold.addItemListener(this);
		italic.addItemListener(this);
		
		pack();
		setSize(800,800);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bold)
		{
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
				val1 = Font.BOLD;
			}
			else
			{
				val1 = Font.PLAIN;
			}
		}
		if(e.getSource() == italic)
		{
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
				val2 = Font.ITALIC;
			}
			else
			{
				val2 = Font.PLAIN;
			}
		}
		
		text.setFont(new Font("TimesRoman",val1+val2,12));
		text.repaint();
	}
}
