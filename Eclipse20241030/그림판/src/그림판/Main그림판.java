package 그림판;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Main그림판 extends JFrame implements ActionListener, MouseListener {
	static enum BtnType {
		도구, 도형, 색상
	};

	static enum DiagramType {
		직선, 원, 사각형, 삼각형
	};

	private MyButton test = new MyButton();
	private ArrayList<MyButton>[] arrBtn = new ArrayList[3];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main그림판 app = new Main그림판();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MyButton btn = (MyButton) e.getSource();

		if (btn.getBtnType() == BtnType.색상) {
			Color c = JColorChooser.showDialog(null, "색상 선택 화면", Color.black);
			btn.setColor(c);
			test.setColor(c);
		}
		else if(btn.getBtnType() == BtnType.도구)
		{
			JOptionPane.showMessageDialog(null, "도구");
		}
		else if(btn.getBtnType() == BtnType.도형)
		{
			JOptionPane.showMessageDialog(null, "도형");
		}
	}

	public Main그림판() {
		super("그림판");
		initialize();
	}

	private void initialize() {
		initButton();
		initializeComponents();
	}

	private void initButton() {
		ArrayList<MyButton> tool = new ArrayList<MyButton>();
		for (int i = 0; i < 4; i++) {
			MyButton btn = new MyButton(BtnType.도구);
			tool.add(btn);
		}

		ArrayList<MyButton> dia = new ArrayList<MyButton>();
		for (int i = 0; i < 4; i++) {
			MyButton btn = new MyButton(BtnType.도형);
			dia.add(btn);
		}

		ArrayList<MyButton> color = new ArrayList<MyButton>();

		for (int i = 0; i < 2; i++) {
			MyButton btn = new MyButton(BtnType.색상);
			color.add(btn);
		}
		color.get(0).setColor(Color.black);
		color.get(1).setColor(Color.white);

		arrBtn[0] = tool;
		arrBtn[1] = dia;
		arrBtn[2] = color;
	}

	private void initializeComponents() {
		Container c = getContentPane();
		Dimension d = c.getPreferredSize();
		d.setSize(d.getWidth() + 500, d.getHeight() + 500);
		
		c.setSize(d);
		System.out.println(c.getSize());
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		c.setLayout(gbl);
		JPanel jp = new JPanel(new GridLayout(2,2,5,5));
		
		for(int i = 0; i < 4; i++)
		{
			jp.add(new MyButton());
		}
		
		gbc.gridx = 0; gbc.gridy = 0;
		c.add(jp,gbc);
		
		

	
		this.setSize(1280, 800);
		setLocation(200, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
