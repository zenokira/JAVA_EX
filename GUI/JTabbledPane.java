package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class JTabbledPane extends JFrame implements ItemListener, ActionListener {

	JButton btn1, btn2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTabbledPane app = new JTabbledPane();
	}

	public JTabbledPane() {
		super("test");
		initializeComponents();
	}

	private void initializeComponents() {
		Container c = getContentPane();
		JTabbedPane pane = new JTabbedPane();

		pane.addTab("tab1", new JTextField(20));

		JPanel panel1 = new JPanel();
		btn1 = new JButton("시작");
		btn2 = new JButton("종료");

		btn1.addActionListener(this);
		btn2.addActionListener(this);

		panel1.add(btn1);
		panel1.add(btn2);

		pane.addTab("tab2", panel1);
		JPanel panel2 = new JPanel();
		panel2.add(new JTextField(10));

		JCheckBox cbaaa = new JCheckBox("aaa");
		panel2.add(cbaaa);
		cbaaa.addItemListener(this);
		;
		pane.addTab("tab3", panel2);
		c.add(pane);

		pack();
		setSize(800, 800);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		JCheckBox cb = (JCheckBox) e.getSource();

		if (e.getStateChange() == ItemEvent.SELECTED) {
			System.out.println(cb.getText() + " selected");
		} else {
			System.out.println(cb.getText() + " deselected");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btn1)
			System.out.println(e.getActionCommand() + " 11눌렸습니다");
		else if(e.getSource() == btn2)
			System.out.println(e.getActionCommand() + " 22눌렸습니다");
		
	}
}
