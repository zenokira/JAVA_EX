package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JCheckBox2 extends JFrame implements ActionListener{
	private JTextField t;
	private JLabel label1, label2;
	private JCheckBox speed, large;
	private JButton button1;
	
	private double cost = 1000;
	private double sum, page;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JCheckBox2 app = new JCheckBox2();
	}

	
	public JCheckBox2()
	{
		super("test");
		initializeComponents();
	}


	private void initializeComponents() {
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,1));
		
		JPanel p1 = new JPanel();
		
		speed = new JCheckBox("신속");
		p1.add(speed);
		large = new JCheckBox("확대");
		p1.add(large);
		c.add(p1);
		
		JPanel p2 = new JPanel();
		label1 = new JLabel("매수");
		p2.add(label1);
	
		t = new JTextField(" ", 15);
		p2.add(t);
		c.add(p2);
		
		JPanel p3 = new JPanel();
		button1 = new JButton("계산");
		button1.addActionListener(this);
		p3.add(button1);
		label2 = new JLabel(" ");
		p3.add(label2);
		c.add(p3);
		
		pack();
		setSize(800,800);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		sum = 0;
		page = Double.parseDouble(t.getText());
		double add1 = 0;
		double add2 = 0;
		
		if(speed.isSelected() == true) add1 = page*cost*0.5;
		if(large.isSelected() == true) add2 = page*cost*0.3;
		
		sum = sum + cost *page + add1 + add2;
		String str = Double.toString(sum);
		label2.setText(str);
	}
}
