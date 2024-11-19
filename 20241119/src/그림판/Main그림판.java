package 그림판;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	private final int frame_MaxHeight = 830;
	private final int panel_MaxWidth = 1100;
	private final int panel_MaxHeight = 750;

	private BasicStroke stroke;
	private int penSize = 1;
	private Color[] preColor = new Color[2];
	private Color Origin;
	private Color textColor;
	private Font textFont;

	boolean pressMouse = false;
	boolean fillFlag = false;
	boolean[] toolFlag = new boolean[4];
	boolean[] diaFlag = new boolean[4];
	boolean textboxFlag = false;
	boolean lineFlag = true;

	private JTextField textbox;
	private MyPanel myPanel;
	private JCheckBox[] chckbox = new JCheckBox[3];
	private ButtonGroup group = new ButtonGroup();
	private JButton fontBtn = new JButton();
	private JMenuItem[] menuItem = new JMenuItem[3];

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

		else if (e.getSource() instanceof JCheckBox) {
			if (e.getSource() == chckbox[0])
				lineFlag = true;
			else if (e.getSource() == chckbox[1])
				lineFlag = false;
			else
				fillFlag = !fillFlag;
			return;
		}

		else if (e.getSource() instanceof MyButton) {
			MyButton btn = (MyButton) e.getSource();

			if (btn.getBtnType() == BtnType.색상) {
				Color c = JColorChooser.showDialog(null, "색상 선택 화면", Color.black);
				if (c == null)
					return;
				btn.setColor(c);
				if (btn == arrBtn[2].get(0)) {
					preColor[0] = btn.getColor();
				} else {
					preColor[1] = btn.getColor();
				}
			}
		}

		else if (e.getSource() instanceof JMenuItem) {
			if (e.getSource() == menuItem[0]) {
				int result = JOptionPane.showConfirmDialog(null, "정말로 새로 만드시겠습니까?", "알림", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					myPanel.setClearImage();
					myPanel.Invalidate();
				} else {
					return;
				}
			} else if (e.getSource() == menuItem[1]) {
				saveImg();
			} else if (e.getSource() == menuItem[2]) {
				int result = JOptionPane.showConfirmDialog(null, "정말로 종료하시겠습니까?", "알림", JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION)
					System.exit(0);
				else
					return;

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

		stroke = new BasicStroke(penSize);
		pressMouse = false;
		fillFlag = false;

		preColor[0] = arrBtn[2].get(0).getColor();
		preColor[1] = arrBtn[2].get(1).getColor();

		textColor = Color.black;
		textFont = new Font("궁서체", Font.BOLD, 16);

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

			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					setArrFlag(toolFlag, btn.getToolType().ordinal());
				}
			});
		}

		tool.get(2).setDiaType(DiagramType.사각형);
		tool.get(3).setDiaType(DiagramType.사각형);

		ArrayList<MyButton> dia = new ArrayList<MyButton>();
		for (int i = 0; i < 4; i++) {
			MyButton btn = new MyButton(BtnType.도형);
			btn.setDiaType(DiagramType.values()[i]);
			dia.add(btn);
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setArrFlag(diaFlag, btn.getDiaType().ordinal());
				}
			});
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

		JMenuBar menuBar = new JMenuBar();

		JMenu menu = new JMenu("파일(F)");
		menu.setMnemonic('F');

		menuItem[0] = new JMenuItem("새로 만들기(N)", 'N');
		menu.add(menuItem[0]);
		menuItem[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

		menuItem[1] = new JMenuItem("저장하기(S)", 'S');
		menu.add(menuItem[1]);
		menuItem[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

		menuItem[2] = new JMenuItem("종료(X)", 'X');
		menu.add(menuItem[2]);
		menuItem[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		menuBar.add(menu);

		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i].addActionListener(this);
		}

		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridBagLayout());

		Dimension d = new Dimension();
		d.setSize(panel_MaxWidth, panel_MaxHeight);
		myPanel = new MyPanel(d, preColor, penSize);
		Origin = myPanel.getOrigin();
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
			gbc.weightx = 1.0;
			gbc.weighty = 0.25;
			addGbcComponent(jp1, ljp[i], 1, 1 + i, gbc, GridBagConstraints.BOTH);
		}
		setBtnPanel(ljp);

		addListenBtn();

		fontBtn.setText("폰트");
		addGbcComponent(ljp[2], fontBtn, 1, 1, gbc);
		JLabel fontLabel = new JLabel("폰트 예시");
		Font imsi = new Font("SanSerif", Font.BOLD, 12);
		fontLabel.setFont(imsi);
		fontLabel.setForeground(textColor);
		fontLabel.setHorizontalAlignment(JLabel.CENTER);
		addGbcComponent(ljp[2], fontLabel, 2, 1, gbc);

		fontBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyFontDlg dlg = new MyFontDlg();
				dlg.setVisible(true);
				textFont = dlg.getFont();
				textColor = dlg.getColor();

				Font imsi = new Font(textFont.getFontName(), textFont.getStyle(), 12);
				fontLabel.setFont(imsi);
				fontLabel.setForeground(textColor);
			}
		});
		addGbcComponent(ljp[2], new JLabel("펜 사이즈 :"), 1, 2, gbc);
		addGbcComponent(ljp[2], cb_penSize, 2, 2, gbc);
		cb_penSize.addActionListener(this);

		for (int i = 0; i < 3; i++) {
			chckbox[i] = new JCheckBox();
			chckbox[i].addActionListener(this);
		}

		addGbcComponent(ljp[3], chckbox[0], 1, 1, gbc, GridBagConstraints.HORIZONTAL);
		addGbcComponent(ljp[3], chckbox[1], 1, 2, gbc, GridBagConstraints.HORIZONTAL);
		addGbcComponent(ljp[3], chckbox[2], 2, 1, gbc, GridBagConstraints.HORIZONTAL);

		group.add(chckbox[0]);
		group.add(chckbox[1]);

		chckbox[0].setText("윤곽선");
		chckbox[1].setText("선 없음");
		chckbox[2].setText("채우기");

		chckbox[0].setSelected(true);

		arrBtn[2].get(0).setText("윤곽선");
		arrBtn[2].get(1).setText("채우기");

		set버튼이미지();

		setJMenuBar(menuBar);
		pack();
		this.setSize(frame_MaxWidth, frame_MaxHeight);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void addGbcComponent(JPanel jp, Component cp, int x, int y, GridBagConstraints gbc, int fill) {
		gbc.fill = fill;
		addGbcComponent(jp, cp, x, y, gbc);
	}

	private void addGbcComponent(JPanel jp, Component cp, int x, int y, GridBagConstraints gbc) {
		gbc.gridx = x;
		gbc.gridy = y;
		jp.add(cp, gbc);
	}

	private void addEvent() {

		myPanel.setEvent(new MyPanel.MouseEv() {
			Point opt;
			BufferedImage oldImg;
			Point evt_start = new Point(), evt_end = new Point();
			Point old_start = new Point(), old_end = new Point();

			@Override
			public void MouseUp(Graphics g, Point start, Point end) {
				// TODO Auto-generated method stub
				GraphicUpdateData(g);
				evt_start = offsetToBoard(start);
				evt_end = offsetToBoard(end);

				if (!diaFlag[0])
					adjustPoint(evt_start, evt_end);

				if (isDiaFlag()) {
					DrawDiagram(g, evt_start, evt_end);
				} else if (isToolFlag()) {
					if (toolFlag[2]) {
						g.setColor(preColor[0]);
					} else if (toolFlag[3]) {
						if (start.equals(end))
							return;

						old_start = pt_offsetToBoard(evt_start.x - penSize, evt_start.y - penSize);
						old_end = pt_offsetToBoard(evt_end.x + penSize, evt_end.y + penSize);

						oldImg = oldImgCopy(myPanel.getBufferImage(), old_start, old_end);

						Stroke oldStroke = ((Graphics2D) g).getStroke();

						drawTextboxLine(g, evt_start, evt_end);

						textbox = createTextbox(evt_start, evt_end);

						myPanel.add(textbox);
						textboxFlag = true;
						textbox.requestFocus();
						textbox.addKeyListener(new KeyListener() {

							@Override
							public void keyTyped(KeyEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void keyPressed(KeyEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void keyReleased(KeyEvent e) {
								// TODO Auto-generated method stub
								if (e.getKeyCode() == KeyEvent.VK_ENTER) {
									drawTextBoxString(g, oldImg, evt_start, evt_end, old_start, old_end);
									myPanel.Invalidate();
								}

							}
						});
					}
				}
				myPanel.Invalidate();
			}

			@Override
			public void MouseDrag(Graphics g, Point pt) {
				// TODO Auto-generated method stub
				if (toolFlag[0]) {
					DrawDiagram(g, opt, pt);
					opt = pt;
					myPanel.Invalidate();
				} else if (toolFlag[2]) {
					useEraser(g, opt, pt);
					opt = pt;
					myPanel.Invalidate();
				}
			}

			@Override
			public void MouseDown(Graphics g, Point pt) {
				// TODO Auto-generated method stub
				GraphicUpdateData(g);
				opt = pt;

				if (toolFlag[0]) {
					DrawDiagram(g, opt, pt);
				} else if (toolFlag[1]) {
					BufferedImage bfImg = myPanel.getBufferImage();
					int standardColor = bfImg.getRGB(opt.x, opt.y);
					if (standardColor == preColor[1].getRGB())
						return;
					Painting(bfImg, opt, preColor[1].getRGB(), standardColor);
				} else if (toolFlag[2]) {
					useEraser(g, pt, pt);
				} else if (toolFlag[3]) {
					if (textboxFlag) {
						drawTextBoxString(g, oldImg, evt_start, evt_end, old_start, old_end);
						myPanel.Invalidate();
					}
				}
				myPanel.Invalidate();
			}
		});
	}

	private void drawTextBoxString(Graphics g, BufferedImage oldImg, Point evt_start, Point evt_end, Point old_start,
			Point old_end) {

		del_TextboxLine(g, oldImg, old_start, old_end);
		drawString(g, evt_start, evt_end);
		myPanel.remove(textbox);

		oldImg = null;
		myPanel.remove(textbox);
		textbox = null;
		textboxFlag = false;
	}

	private void drawString(Graphics g, Point evt_start, Point evt_end) {
		Color oldColor = g.getColor();
		Font oldFont = g.getFont();

		g.setColor(textColor);
		g.setFont(textFont);

		int height = textbox.getBounds().height / 2;
		int penCenter = oldFont.getSize() / 2;
		g.drawString(textbox.getText(), evt_start.x + penSize * 2, evt_start.y + height + penCenter);

		g.setColor(oldColor);
		g.setFont(oldFont);
	}

	private void del_TextboxLine(Graphics g, BufferedImage oldImg, Point old_start, Point old_end) {
		g.drawImage(oldImg, old_start.x, old_start.y, old_end.x, old_end.y, 0, 0, Math.abs(old_start.x - old_end.x),
				Math.abs(old_start.y - old_end.y), null);
	}

	private JTextField createTextbox(Point start, Point end) {
		Point tb_start = offsetToBoard(new Point(start.x + penSize, start.y + penSize));
		Point tb_end = offsetToBoard(new Point(end.x - penSize, end.y - penSize));

		JTextField tf = new JTextField();
		tf.setBounds(tb_start.x, tb_start.y, Math.abs(tb_start.x - tb_end.x), Math.abs(tb_start.y - tb_end.y));

		tf.setFont(textFont);
		tf.setForeground(textColor);
		return tf;
	}

	private void drawTextboxLine(Graphics g, Point start, Point end) {
		float[] dash = { 4, 2, 8, 2 };
		((Graphics2D) g).setStroke(new BasicStroke(penSize, 0, BasicStroke.JOIN_MITER, 1.0f, dash, 0));

		DrawDiagram(g, start, end);
	}

	private BufferedImage oldImgCopy(BufferedImage src, Point start, Point end) {
		int width = Math.abs(start.x - end.x);
		int height = Math.abs(start.y - end.y);

		BufferedImage imsi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D sub = imsi.createGraphics();
		sub.drawImage(src, 0, 0, width, height, start.x, start.y, end.x, end.y, null);
		sub.dispose();
		return imsi;
	}

	private void Painting(BufferedImage bfImg, Point pt, int paintColor, int standardColor) {
		Queue<Point> searchQ = new LinkedList<Point>();
		searchQ.add(pt);
		Point[] gap = new Point[] { newPt(1, 0), newPt(-1, 0), newPt(0, 1), newPt(0, -1) };
		bfImg.setRGB(pt.x, pt.y, paintColor);

		while (!searchQ.isEmpty()) {
			Point q_pt = searchQ.peek();
			searchQ.remove();

			for (int i = 0; i < 4; i++) {
				Point nPt = new Point(q_pt.x + gap[i].x, q_pt.y + gap[i].y);
				if (!ptInBoard(nPt))
					continue;
				if (bfImg.getRGB(nPt.x, nPt.y) == standardColor) {
					bfImg.setRGB(nPt.x, nPt.y, paintColor);
					searchQ.add(nPt);
				}
			}
		}
	}

	private Point newPt(int i, int j) {
		// TODO Auto-generated method stub
		return new Point(i, j);
	}

	private boolean rectInBoard(Point pt1, Point pt2) {
		return ptInBoard(pt1) && ptInBoard(pt2);
	}

	private void adjustPoint(Point start, Point end) {
		int imsi = 0;
		if (start.x > end.x) {
			imsi = start.x;
			start.x = end.x;
			end.x = imsi;
		}
		if (start.y > end.y) {
			imsi = start.y;
			start.y = end.y;
			end.y = imsi;
		}
	}

	private Point offsetToBoard(Point pt) {
		Point contourPt = new Point(myPanel.getWidth(), myPanel.getHeight());
		Point npt = (Point) pt.clone();
		if (!ptInBoard(npt)) {
			if (npt.x < 0)
				npt.x = 0;
			else if (npt.x > contourPt.x)
				npt.x = contourPt.x;

			if (npt.y < 0)
				npt.y = 0;
			else if (npt.y > contourPt.y)
				npt.y = contourPt.y;

			return npt;
		} else
			return npt;
	}

	private Point pt_offsetToBoard(int x, int y) {
		Point contourPt = new Point(myPanel.getWidth(), myPanel.getHeight());
		Point npt = newPt(x, y);
		if (!ptInBoard(npt)) {
			if (npt.x < 0)
				npt.x = 0;
			else if (npt.x > contourPt.x)
				npt.x = contourPt.x;

			if (npt.y < 0)
				npt.y = 0;
			else if (npt.y > contourPt.y)
				npt.y = contourPt.y;

			return npt;
		} else
			return npt;
	}

	private boolean ptInBoard(int x, int y) {
		return !(x < 0 || y < 0 || x >= myPanel.getWidth() || y >= myPanel.getHeight());
	}

	private boolean ptInBoard(Point pt) {
		return !(pt.x < 0 || pt.y < 0 || pt.x >= myPanel.getWidth() || pt.y >= myPanel.getHeight());
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
				gbc.fill = GridBagConstraints.HORIZONTAL;
				jp[n].add(arrBtn[n].get(i), gbc);
			}
		}

		for (int i = 0; i < 2; i++) {
			gbc.weightx = 0.5;
			gbc.weighty = 1.0;
			addGbcComponent(jp[3], arrBtn[2].get(i), 1 + i, 3, gbc, GridBagConstraints.BOTH);
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

	private void GraphicUpdateData(Graphics g) {
		((Graphics2D) g).setStroke(stroke);
		((Graphics2D) g).setColor(preColor[0]);
	}

	private void DrawDiagram(Graphics g, Point start, Point end) {

		Point[] pt = getDiaPoint(start, end);

		int width = Math.abs(pt[0].x - pt[1].x);
		int height = Math.abs(pt[0].y - pt[1].y);

		if (diaFlag[0] || toolFlag[0]) {
			g.drawLine(start.x, start.y, end.x, end.y);
		} else {
			drawPolyDia(g, pt, width, height, whatDiaFlag());
		}
	}

	private void drawPolyDia(Graphics g, Point[] pt, int width, int height, int type) {
		if (type == 1)
			drawOval(g, pt[0], width, height);
		else if (type == 2)
			drawTriangle(g, pt);
		else if (type == 3 || toolFlag[3] == true)
			drawRect(g, pt[0], width, height);
	}

	private void drawOval(Graphics g, Point pt, int width, int height) {
		if (fillFlag) {
			Color imsi = g.getColor();
			g.setColor(preColor[1]);
			g.fillOval(pt.x, pt.y, width, height);
			g.setColor(imsi);
		}
		if (lineFlag)
			g.drawOval(pt.x, pt.y, width, height);
	}

	private void drawTriangle(Graphics g, Point[] pt) {
		int x[] = { (pt[1].x - pt[0].x) / 2 + pt[0].x, pt[0].x, pt[1].x };
		int y[] = { pt[0].y, pt[1].y, pt[1].y };

		if (fillFlag) {
			Color imsi = g.getColor();
			g.setColor(preColor[1]);
			g.fillPolygon(x, y, 3);
			g.setColor(imsi);
		}
		if (lineFlag)
			g.drawPolygon(x, y, 3);
	}

	private void drawRect(Graphics g, Point pt, int width, int height) {
		if (fillFlag) {
			Color oldColor = g.getColor();
			g.setColor(preColor[1]);
			g.fillRect(pt.x, pt.y, width, height);
			g.setColor(oldColor);
		}
		if (lineFlag)
			g.drawRect(pt.x, pt.y, width, height);
	}

	private void DrawLine(Graphics g, Point opt, Point pt) {
		// TODO Auto-generated method stub
		g.drawLine(opt.x, opt.y, pt.x, pt.y);
	}

	private void useEraser(Graphics g, Point start, Point end) {
		g.setColor(Origin);
		g.drawLine(start.x, start.y, end.x, end.y);
		g.setColor(preColor[0]);
	}

	private boolean isToolFlag() {
		for (int i = 0; i < 4; i++) {
			if (toolFlag[i])
				return true;
		}
		return false;
	}

	private boolean isDiaFlag() {
		for (int i = 0; i < 4; i++) {
			if (diaFlag[i])
				return true;
		}
		return false;
	}

	private int whatDiaFlag() {
		for (int i = 0; i < 4; i++) {
			if (diaFlag[i])
				return i;
		}
		return -1;
	}

	private int whatFlag() {
		if (isToolFlag())
			return 1;
		else if (isDiaFlag())
			return 2;
		else
			return -1;
	}

	private void saveImg() {
		JFileChooser jfc = new JFileChooser();
		FileNameExtensionFilter defaultFilter;
		jfc.addChoosableFileFilter(defaultFilter = new FileNameExtensionFilter("JPG 파일 (*.jpg)", "jpg"));
		jfc.addChoosableFileFilter(new FileNameExtensionFilter("비트맵 파일 (*.bmp)", "bmp"));
		jfc.addChoosableFileFilter(new FileNameExtensionFilter("GIF 파일 (*.gif)", "gif"));
		jfc.setFileFilter(defaultFilter);
		int response = jfc.showSaveDialog(null);

		if (response != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(this, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			String filename = jfc.getSelectedFile().toString();
			String filter = jfc.getFileFilter().getDescription().toString();
			filter = filter.substring(filter.lastIndexOf("."), filter.length() - 1);

			String path = filename + filter;
			File outFile = new File(path);
			try {
				String type = filter.substring(filter.lastIndexOf(".") + 1, filter.length());
				ImageIO.write(myPanel.getBufferImage(), type, outFile);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
