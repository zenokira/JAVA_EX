package main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {
	JTextField txtfld;
	boolean isOperatorSelect = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator start = new Calculator("계산기");
	}

	public Calculator(String s) {
		super(s);
		initializeComponents();
	}

	private void initializeComponents() {
		Container c = getContentPane();

		BoxLayout layout = new BoxLayout(c, BoxLayout.Y_AXIS);
		c.setLayout(layout);

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();

		c.add(p1);
		c.add(Box.createRigidArea(new Dimension(0, 8)));
		c.add(p2);

		JButton btn;

		p1.setLayout(new GridLayout());
		txtfld = new JTextField();

		p1.add(txtfld);
		Font font = new Font("", 1, 30);
		txtfld.setFont(font);

		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p2.add(p3);
		p2.add(Box.createRigidArea(new Dimension(5, 0)));
		p2.add(p4);

		p3.setLayout(new GridLayout(4, 3, 5, 5));
		for (int i = 0; i < 3; i++) {
			for (int n = 7; n <= 9; n++) {
				btn = new JButton(Integer.toString(n - (i * 3)));
				p3.add(btn);
				btn.addActionListener(this);
			}
		}

		btn = new JButton("C");
		p3.add(btn);
		btn.addActionListener(this);

		btn = new JButton("0");
		p3.add(btn);
		btn.addActionListener(this);

		btn = new JButton(".");
		p3.add(btn);
		btn.addActionListener(this);

		p4.setLayout(new GridLayout(5, 1, 5, 5));

		btn = new JButton("/");
		p4.add(btn);
		btn.addActionListener(this);
		btn = new JButton("*");
		p4.add(btn);
		btn.addActionListener(this);
		btn = new JButton("-");
		p4.add(btn);
		btn.addActionListener(this);
		btn = new JButton("+");
		p4.add(btn);
		btn.addActionListener(this);
		btn = new JButton("=");
		p4.add(btn);
		btn.addActionListener(this);

		pack();
		setSize(300, 300);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();

		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(str);

		if (m.find()) {
			txtfld.setText(txtfld.getText() + str);
			isOperatorSelect = false;
		} else if (str.equals("=")) {
			String calc = txtfld.getText();

			calc = calc.replaceAll(" ", "");
			
			if (calc.length() == 0 || !isNumEnd(calc)) return;
			
			double result = 계산하기(calc);

			if (isInteger(result))
				txtfld.setText(Integer.toString((int) result));
			else
				txtfld.setText(Double.toString(result));

			isOperatorSelect = false;

		} else if (str.equals("C")) {
			txtfld.setText("");
			isOperatorSelect = false;
		} else {
			if (isOperatorSelect) {
				String text = del_Operator(txtfld.getText());
				txtfld.setText(text + " %s ".formatted(str));
			} else {
				txtfld.setText(txtfld.getText() + " %s ".formatted(str));
				isOperatorSelect = true;
			}
		}
	}

	private String del_Operator(String str) {
		String result = str.substring(0, str.length() - 3);
		return result;
	}

	private boolean isNumEnd(String str) {
		char n = str.charAt(str.length() - 1);

		return Character.isDigit(n);
	}

	private boolean isInteger(Double num) {
		return num % 1 == 0.0;
	}

	private double 계산하기(String calc) {

		if (!isNumEnd(calc)) {
			calc = calc.substring(0, calc.length() - 1);
		}

		ArrayList<String> list = new ArrayList<>();
		Pattern p = Pattern.compile("\\d*\\.?\\d+|\\D");
		Matcher m = p.matcher(calc);

		while (m.find()) {
			String split = m.group();
			list.add(split);
		}

		ArrayList<String> list2 = new ArrayList<String>();

		if (list.contains("*") || list.contains("/")) {
			for (int i = 0; i < list.size(); i++) {
				String s = list.get(i);
				if (s.equals("*") || s.equals("/")) {
					i++;
					Double d = Double.parseDouble(list2.get(list2.size() - 1));

					switch (s) {
					case "*":
						d *= Double.parseDouble(list.get(i));
						break;
					case "/":
						d /= Double.parseDouble(list.get(i));
						break;
					}

					list2.remove(list2.size() - 1);
					list2.add(d.toString());
				} else {
					list2.add(list.get(i));
				}
			}
		}
		else
		{
			list2 = (ArrayList<String>)list.clone();
		}

		Double result = Double.parseDouble(list2.get(0));
		for (int i = 1; i < list2.size(); i += 2) {
			String s = list2.get(i);

			switch (s) {
			case "+":
				result += Double.parseDouble(list2.get(i + 1));
				break;
			case "-":
				result -= Double.parseDouble(list2.get(i + 1));
				break;
			}
		}

		return result;
	}
}
