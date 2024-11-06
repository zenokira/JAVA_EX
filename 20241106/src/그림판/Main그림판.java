package 그림판;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import java.util.Arrays;

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

public class Main그림판 extends JFrame implements ActionListener {
	static enum BtnType {
		도구, 도형, 색상
	};

	static enum DiagramType {
		직선, 원, 사각형, 삼각형
	};

	static enum ToolType {
		펜, 페인트, 지우개, 글상자
	}

	private ArrayList<MyButton>[] arrBtn = new ArrayList[3];
	private JComboBox cb_penSize = new JComboBox();
	private final int frame_MaxWidth = 1280;
	private final int frame_MaxHeight = 800;

	private BasicStroke stroke;
	private int penSize = 1;

	boolean pressMouse = false;
	boolean[] toolFlag = new boolean[4];
	boolean[] diaFlag = new boolean[4];
	private Color preColor;

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
			stroke = new BasicStroke(penSize);
			myPanel.setStroke(stroke);
			return;
		}

		if (e.getSource() instanceof MyButton) {
			MyButton btn = (MyButton) e.getSource();

			if (btn.getBtnType() == BtnType.색상) {
				Color c = JColorChooser.showDialog(null, "색상 선택 화면", Color.black);
				btn.setColor(c);
				preColor = c;
			} else if (btn.getBtnType() == BtnType.도구) {
				int idx = btn.getToolType().ordinal();
				setArrFlag(toolFlag, idx);

			} else if (btn.getBtnType() == BtnType.도형) {
				int idx = btn.getDiaType().ordinal();
				setArrFlag(diaFlag, idx);
			}
		}
	}

	private void setArrFlag(boolean[] flag, int n) {
		Arrays.fill(toolFlag, false);
		Arrays.fill(diaFlag, false);
		flag[n] = true;
	}

	public Main그림판() {
		super("그림판");
		initialize();
	}

	private void initialize() {
		initButton();
		initComboBox();

		preColor = arrBtn[2].get(0).getColor();
		stroke = new BasicStroke(penSize);
		pressMouse = false;

		initializeComponents();

	}

	private void initComboBox() {
		for (int i = 0; i < 10; i++) {
			cb_penSize.addItem(Integer.toString(i + 1));
		}
		cb_penSize.setSelectedIndex(4);
		UpdateData();
	}

	private void UpdateData() {
		penSize = Integer.parseInt(cb_penSize.getSelectedItem().toString());
	}

	private void initButton() {
		ArrayList<MyButton> tool = new ArrayList<MyButton>();
		for (int i = 0; i < 4; i++) {
			MyButton btn = new MyButton(BtnType.도구);
			btn.setToolType(ToolType.values()[i]);
			tool.add(btn);
		}

		ArrayList<MyButton> dia = new ArrayList<MyButton>();
		for (int i = 0; i < 4; i++) {
			MyButton btn = new MyButton(BtnType.도형);
			btn.setDiaType(DiagramType.values()[i]);
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

		JPanel jp1 = new JPanel();
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
		jp1.setLayout(new GridBagLayout());

		Dimension d = new Dimension();
		d.setSize(1100, 750);
		myPanel = new MyPanel(d, preColor, penSize);
		addEvent();

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

	private void addEvent() {
		
		myPanel.setEvent(new MyPanel.MouseEv() {
			Point opt;
			
			@Override
			public void MouseUp(Graphics g, Point start, Point end) {
				// TODO Auto-generated method stub
				GraphicUpdateData(g);
				if(isDiaFlag())	DrawDiagram(g, start, end);
				else if(isToolFlag() )
				{
					
				}
				myPanel.Invalidate();
			}

			@Override
			public void MouseDrag(Graphics g, Point pt) {
				// TODO Auto-generated method stub
				if (toolFlag[0]) {
					g.drawLine(opt.x, opt.y, pt.x, pt.y);
					
					opt = pt;
				}
				else if(toolFlag[1])
				{

					
				}
				else if(toolFlag[2])
				{

					
				}
				else if(toolFlag[3])
				{

					
				}
				myPanel.Invalidate();
			}

			@Override
			public void MouseDown(Graphics g, Point pt) {
				// TODO Auto-generated method stub
				if (toolFlag[0]) {
					opt = pt;
					g.drawLine(pt.x, pt.y, pt.x, pt.y);
					myPanel.Invalidate();
				}
				else if(toolFlag[1])
				{

					
				}
				else if(toolFlag[2])
				{
					opt = pt;
					myPanel.Invalidate();
				}
				else if(toolFlag[3])
				{

					
				}
			}
		});
	}

	private void set버튼이미지() {

		for (int i = 0; i < 2; i++) {
			for (int n = 0; n < 4; n++) {
				MyButton btn = arrBtn[i].get(n);
				String s;
				if (i == 0)
					s = String.format("img\\img_tool%d.jpg", n + 1);
				else
					s = String.format("img\\img_dia%d.jpg", n + 1);
				loadBtnImage(btn, s);
			}
		}
	}

	private void loadBtnImage(MyButton btn, String path) {
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

	private Point[] getDiaPoint(Point s, Point e) {
		Point[] pt = new Point[2];
		pt[0] = new Point();
		pt[1] = new Point();

		if (s.x > e.x) {
			pt[0].x = e.x;
			pt[1].x = s.x;
		} else {
			pt[0].x = s.x;
			pt[1].x = e.x;
		}

		if (s.y > e.y) {
			pt[0].y = e.y;
			pt[1].y = s.y;
		} else {
			pt[0].y = s.y;
			pt[1].y = e.y;
		}

		return pt;
	}

	private void drawTriangle(Graphics g, Point[] pt) {
		int x[] = { (pt[1].x - pt[0].x) / 2 + pt[0].x, pt[0].x, pt[1].x };
		int y[] = { pt[0].y, pt[1].y, pt[1].y };

		g.drawPolygon(x, y, 3);
	}

	private void GraphicUpdateData(Graphics g) {
		g.setColor(preColor);
		((Graphics2D) g).setStroke(stroke);
	}

	private void DrawDiagram(Graphics g, Point start, Point end) {
		
		Point[] pt = getDiaPoint(start, end);

		int width = Math.abs(pt[0].x - pt[1].x);
		int height = Math.abs(pt[0].y - pt[1].y);

		
		if (diaFlag[0]) {
			g.drawLine(start.x, start.y, end.x, end.y);
		} 
		else if (diaFlag[1]) {
			g.drawOval(pt[0].x, pt[0].y, width, height);
		} 
		else if (diaFlag[2]) {
			drawTriangle(g, pt);
		} 
		else if (diaFlag[3]) {
			g.drawRect(pt[0].x, pt[0].y, width, height);
		}
	}

	private boolean isToolFlag()
	{
		for(int i = 0 ; i < 4; i++)
		{
			if( toolFlag[i] ) return true;
		}
		return false;
	}
	private boolean isDiaFlag()
	{
		for(int i = 0 ; i < 4; i++)
		{
			if( diaFlag[i] ) return true;
		}
		return false;
	}
	
	private int whatFlag()
	{
		if(isToolFlag()) return 1;
		else if(isDiaFlag()) return 2;
		else return -1;
	}
}


