package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Gugudan extends JFrame implements ItemListener, ActionListener{
	
	private JComboBox combo;
	private String num[] = {"2","3","4","5","6","7","8","9"};
	private JTextArea list;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gugudan app = new Gugudan();
	}
	
	public Gugudan() {
		super("test");
		initializeComponents();
	}

	private void initializeComponents() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		combo = new JComboBox(num);
		combo.setMaximumRowCount(6);
		combo.addActionListener(this);
		combo.addItemListener(this);
		c.add(combo);
		
		
		list = new JTextArea(10,20);
		c.add(list);
		combo.setSelectedIndex(0);
		
		pack();
		setSize(800,800);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(combo.getSelectedIndex() < 0 ) return;
		
		int dan = combo.getSelectedIndex() + 2;
		
		String res = "";
		
		for(int i = 1; i <= 9; i++)
		{
			res = res + dan + " * " + i + " = " + dan*i + "\n";
			list.setText(res);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		itemStateChanged(null);
	}
}
