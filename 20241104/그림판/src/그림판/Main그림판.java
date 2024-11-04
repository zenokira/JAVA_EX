package 그림판;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
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
	private final int frame_MaxWidth = 1280;
	private final int frame_MaxHeight = 800;
	

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
		} else if (btn.getBtnType() == BtnType.도구) {
			JOptionPane.showMessageDialog(null, "도구");
		} else if (btn.getBtnType() == BtnType.도형) {
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
		c.setLayout(new BorderLayout());
		c.setBackground(Color.black);
		
		
		
		JPanel jp1 = new JPanel(new GridBagLayout());
		//JPanel jp1 = new JPanel();
		jp1.setBackground(Color.red);
		
	
		JPanel jp2 = new JPanel();
		
		jp2.setBackground(Color.blue);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.gridwidth = 40; gbc.gridwidth = 40;
		gbc.weightx = 0.2; gbc.weighty = 0.1;
		
		
		Dimension d = new Dimension();
	
		
		MyButton btn = new MyButton();
		btn.setMybtnSize(40);
			
		c.add(jp1,BorderLayout.WEST);
		c.add(jp2,BorderLayout.CENTER);
	
		d = jp1.getPreferredSize() ;
		d.setSize(150, 600);
		jp1.setPreferredSize(d);
		
		
		JPanel ljp1 = new JPanel(new FlowLayout());
		JPanel ljp2 = new JPanel(new FlowLayout());
		JPanel ljp3 = new JPanel(new FlowLayout());
		JPanel ljp4 = new JPanel(new FlowLayout());
		
		jp1.add(ljp1);
		jp1.add(ljp2);
		jp1.add(ljp3);
		jp1.add(ljp4);
		
		ljp1.setBackground(Color.yellow);
		ljp2.setBackground(Color.black);
		ljp3.setBackground(Color.CYAN);
		ljp4.setBackground(Color.gray);
		
		 
		d.setSize(130, 150);
		ljp1.setPreferredSize(d);
		ljp2.setPreferredSize(d);
		ljp3.setPreferredSize(d);
		ljp4.setPreferredSize(d);
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println(jp1.getPreferredSize() );
		
		pack();
		this.setSize(frame_MaxWidth, frame_MaxHeight);
		this.setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	

	private void gbc_add(Component dst, Component src, int x, int y, int width, int height) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.fill = GridBagConstraints.BOTH;

		if (dst instanceof JPanel)
			((JPanel) dst).add(src, gbc);
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
