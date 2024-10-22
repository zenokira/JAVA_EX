package Menu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MenuDemo extends JFrame implements ActionListener, ItemListener {

	private JMenuItem aboutItem, exitItem;
	private Color colValues[] = { Color.red, Color.green, Color.blue, Color.black };
	private JRadioButtonMenuItem colorItems[], fontItems[];
	private JCheckBoxMenuItem styleItems[];
	private JLabel testMsg;
	private ButtonGroup fontGroup, colorGroup;
	private int style;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuDemo app = new MenuDemo();

	}

	public MenuDemo() {
		super("test");
		intializeComponents();
	}

	private void intializeComponents() {
		// TODO Auto-generated method stub

		constructMenu();

		testMsg = new JLabel("테스트용 문자열");
		testMsg.setForeground(colValues[0]);
		testMsg.setFont(new Font("궁서체", Font.PLAIN, 72));

		getContentPane().add(testMsg);

		setSize(507, 500);
		setVisible(true);
	}

	private void constructMenu() {
		// TODO Auto-generated method stub
		JMenuBar bar = new JMenuBar();

		JMenu fileMenu = new JMenu("파일(F)");
		fileMenu.setMnemonic('F');
		aboutItem = new JMenuItem("About...");
		aboutItem.setMnemonic('A');
		aboutItem.addActionListener(this);
		fileMenu.add(aboutItem);

		exitItem = new JMenuItem("종료(X)");
		exitItem.setMnemonic('X');
		exitItem.addActionListener(this);
		fileMenu.add(exitItem);

		bar.add(fileMenu);

		JMenu formatMenu = new JMenu("포맷(M)");
		formatMenu.setMnemonic('M');
		String colors[] = { "빨강", "녹색", "파랑", "검정" };
		JMenu colorMenu = new JMenu("컬러(C)");
		colorMenu.setMnemonic('C');
		colorItems = new JRadioButtonMenuItem[colors.length];
		colorGroup = new ButtonGroup();

		for (int i = 0; i < colors.length; i++) {
			colorItems[i] = new JRadioButtonMenuItem(colors[i]);
			colorMenu.add(colorItems[i]);
			colorGroup.add(colorItems[i]);
			colorItems[i].addActionListener(this);
		}

		colorItems[0].setSelected(true);
		formatMenu.add(colorMenu);
		formatMenu.addSeparator();

		String fontNames[] = { "궁서체", "맑은고딕", "바탕" };
		JMenu fontMenu = new JMenu("폰트(N)");
		fontMenu.setMnemonic('N');
		fontItems = new JRadioButtonMenuItem[fontNames.length];
		fontGroup = new ButtonGroup();

		for (int i = 0; i < fontItems.length; i++) {
			fontItems[i] = new JRadioButtonMenuItem(fontNames[i]);
			fontMenu.add(fontItems[i]);
			fontGroup.add(fontItems[i]);
			fontItems[i].addActionListener(this);
		}

		fontItems[0].setSelected(true);
		fontMenu.addSeparator();

		String styleNames[] = { "Bold", "Italic" };
		styleItems = new JCheckBoxMenuItem[styleNames.length];

		for (int i = 0; i < styleNames.length; i++) {
			styleItems[i] = new JCheckBoxMenuItem(styleNames[i]);
			fontMenu.add(styleItems[i]);
			styleItems[i].addActionListener(this);
		}

		formatMenu.add(fontMenu);
		bar.add(formatMenu);
		setJMenuBar(bar);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		style = 0;
		
		if(styleItems[0].isSelected()) style += Font.BOLD;
		if(styleItems[1].isSelected()) style += Font.ITALIC;
		
		String fontName = testMsg.getFont().getName();
		testMsg.setFont(new Font (fontName, style, 72));
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == aboutItem)
			JOptionPane.showMessageDialog(null, "메뉴 예제 프로그램입니다.");
		else if (e.getSource() == exitItem)
			System.exit(0);
		else {
			for (int i = 0; i < colorItems.length; i++) {
				if (colorItems[i].isSelected()) {
					testMsg.setForeground(colValues[i]);
					break;
				}
			}
			for (int i = 0; i < fontItems.length; i++) {
				if (e.getSource() == fontItems[i]) {
					testMsg.setFont(new Font(fontItems[i].getText(), style, 72));
					break;
				}
			}
			repaint();
		}
		
	}
}
