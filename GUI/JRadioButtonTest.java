package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class JRadioButtonTest extends JFrame implements ItemListener, ActionListener {
	JRadioButton r1, r2, r3, r4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JRadioButtonTest app = new JRadioButtonTest();
	}
	
	public JRadioButtonTest() {
		super("test");
		initializeComponents();
	}

	private void initializeComponents() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JPanel p1 = new JPanel();
		ButtonGroup g1 = new ButtonGroup();
		r1 = new JRadioButton("라디오 버튼1");
		r1.addActionListener(this);
		//r1.addItemListener(this);
		g1.add(r1);
		p1.add(r1);
		r2 = new JRadioButton("라디오 버튼2");
		r2.addActionListener(this);
		//r2.addItemListener(this);
		g1.add(r2);
		p1.add(r2);
		p1.setBorder(new TitledBorder("옵션1"));
		c.add(p1);
		
		JPanel p2 = new JPanel();
		ButtonGroup g2 = new ButtonGroup();
		r3 = new JRadioButton("라디오 버튼3");
		r3.addActionListener(this);
		//r3.addItemListener(this);
		g2.add(r3);
		p2.add(r3);
		r4 = new JRadioButton("라디오 버튼4");
		r4.addActionListener(this);
		//r4.addItemListener(this);
		g2.add(r4);
		p2.add(r4);
		p2.setBorder(new TitledBorder("옵션2"));
		c.add(p2);
		
		
		pack();
		setSize(800,800);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.DESELECTED)
		{
			System.out.println(((JRadioButton)e.getSource()).getText() + "deselected");
		}
		else
		{
			System.out.println(((JRadioButton)e.getSource()).getText() + "selected");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JRadioButton rb = (JRadioButton) e.getSource();
		JOptionPane.showMessageDialog(null, rb.getText());
	}
}
