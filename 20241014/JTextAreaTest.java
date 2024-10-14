package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaTest extends JFrame implements ActionListener{
	private JTextArea t1, t2;
	private JButton copy, copy2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTextAreaTest app = new JTextAreaTest();
	}

	
	public JTextAreaTest()
	{
		super("test");
		initializeComponents();
	}


	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		
		Box b = Box.createVerticalBox();
		String s = "이벤트 핸들러 객체는 하나의 메서드\n" + "알겠나?\n";
		
		t1 = new JTextArea (s, 10, 15);
		b.add(new JScrollPane(t1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		
		copy = new JButton("COPY >>>");
		copy.addActionListener(this);
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,2));
		p.add(copy);
		
		copy2 = new JButton("<<< COPY");
		copy2.addActionListener(this);
		p.add(copy2);
		
		b.add(p);
		
		t2 = new JTextArea(10,15);
		b.add(new JScrollPane(t2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
				
		c.add(b);
		
		setSize(800,800);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String s ="";
		
		if( e.getSource() == copy)
		{
			s = t2.getText();
			t2.setText(s + t1.getSelectedText());
		}
		else if( e.getSource() == copy2)
		{
			s = t1.getText();
			t1.setText(s + t2.getSelectedText());
		}
	
	}
}
