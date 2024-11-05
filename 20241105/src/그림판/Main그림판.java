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
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
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
	private JComboBox cb_penSize = new JComboBox();
	private final int frame_MaxWidth = 1280;
	private final int frame_MaxHeight = 800;
	private int penSize = 1;
	ButtonGroup group = new ButtonGroup();
	
	private MyPanel myPanel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main그림판 app = new Main그림판();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == cb_penSize) {
			int size = Integer.parseInt(cb_penSize.getSelectedItem().toString());
			penSize = size;
			return;
		}

		MyButton btn = (MyButton) e.getSource();

		if (btn.getBtnType() == BtnType.색상) {
			Color c = JColorChooser.showDialog(null, "색상 선택 화면", Color.black);
			btn.setColor(c);
			test.setColor(c);
		} else if (btn.getBtnType() == BtnType.도구) {

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
		initComboBox();
		initializeComponents();
	}

	private void initComboBox()
	{
		for (int i = 0; i < 10; i++) {
			cb_penSize.addItem(Integer.toString(i + 1));
		}
		cb_penSize.setSelectedIndex(4);
		UpdateData();
	}
	
	private void UpdateData()
	{
		penSize = Integer.parseInt(cb_penSize.getSelectedItem().toString());
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
		c.setLayout(new FlowLayout());
		c.setBackground(Color.black);

		JPanel jp1 = new JPanel();
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
		jp1.setLayout(new GridBagLayout());

		jp1.setBackground(Color.red);
		
		Dimension d = new Dimension();
		d.setSize(1100,750);
		myPanel = new MyPanel(d);
		myPanel.setBackground(Color.blue);

		myPanel.setEvent(new MyPanel.MouseEv() {
			
			@Override
			public void MouseUp() {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		c.add(jp1, BorderLayout.WEST);
		c.add(myPanel, BorderLayout.CENTER);
		
		d = jp1.getPreferredSize();
		d.setSize(150, 750);
		jp1.setPreferredSize(d);


		JPanel[] ljp = new JPanel[4];

		ljp[0] = new JPanel(new GridBagLayout());
		ljp[1] = new JPanel(new GridBagLayout());
		ljp[2] = new JPanel(new GridBagLayout());
		ljp[3] = new JPanel(new GridBagLayout());

		ljp[0].setBackground(Color.yellow);
		ljp[1].setBackground(Color.black);
		ljp[2].setBackground(Color.CYAN);
		ljp[3].setBackground(Color.gray);

		GridBagConstraints gbc = new GridBagConstraints();
		for (int i = 0; i < 4; i++) {
			gbc.gridx = 1;
			gbc.gridy = 1 + i;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weightx = 1.0;
			gbc.weighty = 0.25;

			jp1.add(ljp[i], gbc);
		}
		setBtnPanel(ljp);

		addListenBtn();

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		ljp[2].add(cb_penSize, gbc);
		cb_penSize.addActionListener(this);
		set버튼이미지();
		
		
		
		
		
		

		pack();
		this.setSize(frame_MaxWidth, frame_MaxHeight);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void set버튼이미지() {

		for (int i = 0; i < 2; i++) {
			for (int n = 0; n < 4; n++) {
				MyButton btn = arrBtn[i].get(n);
				String s;
				if(i == 0 ) s = String.format("img\\img_tool%d.jpg", n + 1);
				else 		s = String.format("img\\img_dia%d.jpg", n + 1);
				setBtnImage(btn, s);
			}
		}
	}

	private void setBtnImage(MyButton btn, String path) {
		ImageIcon icon = new ImageIcon(path);
		Image Img = icon.getImage();
		Image subImg = Img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		icon = new ImageIcon(subImg);
		btn.setIcon(icon);
	}

	private void addListenBtn() {
		for (int i = 0; i < arrBtn.length; i++) {
			for (int n = 0; n < arrBtn[i].size(); n++) {
				arrBtn[i].get(n).addActionListener(this);
			}
		}
	}

	private void setBtnPanel(JPanel[] jp) {
		GridBagConstraints gbc = new GridBagConstraints();

		for (int n = 0; n < 2; n++) {
			for (int i = 0; i < arrBtn[0].size(); i++) {
				gbc.gridx = 1 + i % 2;
				gbc.gridy = 1 + (i + 2) / 2;
				gbc.weightx = 0.5;
				// gbc.weighty = 1.0;
				gbc.fill = GridBagConstraints.HORIZONTAL;
				jp[n].add(arrBtn[n].get(i), gbc);
			}
		}

		for (int i = 0; i < 2; i++) {
			gbc.gridx = 1 + i;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 0.5;
			gbc.weighty = 1.0;
			jp[3].add(arrBtn[2].get(i), gbc);
		}
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
