package GUI;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class JComboBoxTest extends JFrame implements ItemListener{
	
	private JComboBox combo;
	private String names[] = {"aaa","bbb","ccc","ddd","eee"};
	private JLabel display;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JComboBoxTest app = new JComboBoxTest();
	}
	
	public JComboBoxTest() {
		super("test");
		initializeComponents();
	}

	private void initializeComponents() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		combo = new JComboBox(names);
		combo.setMaximumRowCount(3);
		c.add(combo);
		combo.addItemListener(this);
		
		display = new JLabel(names[0]);
		c.add(display);
		
		pack();
		setSize(800,800);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		display.setText(names[combo.getSelectedIndex()]);
	}
}
