package 그림판;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFontDlg extends JDialog implements ActionListener {
	Font font;
	private Color color = Color.black;
	private String type1 = "궁서체";
	private int type2 = Font.BOLD;
	private int size = 8;
	
	private Graphics g;
	private JComboBox textcombo = new JComboBox();
	private JComboBox sizecombo = new JComboBox();
	
	private String exTextString = "폰트를 적용한 글씨 입니다";
	private JLabel exText = new JLabel(exTextString);
	private JButton btn = new JButton("색상");
	private JPanel jpChoose = new JPanel();
	private JPanel jp = new JPanel(new FlowLayout());
	private JPanel jpEnd = new JPanel();
 
	public MyFontDlg() {
		super();
		
		initializeComponents();
	}

	private void initializeComponents() {
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		
		jpChoose.setLayout(new GridBagLayout());
	
		c.add(jpChoose);

		JLabel[] lb = new JLabel[3];

		lb[0] = new JLabel("글씨체 : ");
		lb[1] = new JLabel("크기     : ");
		lb[2] = new JLabel("색상     : ");

		GridBagConstraints gbc = new GridBagConstraints();

		addGbcComponent(jpChoose,lb[0],1,1,gbc);
		addGbcComponent(jpChoose,lb[1],1,2,gbc);
		addGbcComponent(jpChoose,lb[2],1,3,gbc);
		
		textcombo.addItem("SanSerif");
		textcombo.addItem("Monospaced");
		textcombo.addItem("Dialog");
		textcombo.addItem("궁서체");

		textcombo.setSelectedIndex(0);

		addGbcComponent(jpChoose,textcombo, 2,1,gbc,GridBagConstraints.HORIZONTAL);
		textcombo.addActionListener(this);
		

		for (int i = 1; i < 8; i++) {
			sizecombo.addItem(Integer.toString((int) Math.pow(2, i)));
		}
		sizecombo.setSelectedIndex(4);
		size = Integer.parseInt(sizecombo.getSelectedItem().toString());
		
		addGbcComponent(jpChoose,sizecombo, 2,2,gbc,GridBagConstraints.HORIZONTAL);
		sizecombo.addActionListener(this);
		
		addGbcComponent(jpChoose,btn, 2,3,gbc,GridBagConstraints.HORIZONTAL);
		btn.addActionListener(this);
		
		c.add(jp);
		
		Dimension d = jp.getPreferredSize();
		d.height = d.height + 200;
		jp.setPreferredSize(d);
		jp.add(exText);
		font = new Font(type1,type2, size);
		exText.setFont(font);
		exText.setText(exTextString);
		
		JButton btn = new JButton("적용");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyFontDlg.this.dispose();
			}
		});
		
		c.add(jpEnd);
		jpEnd.add(btn);
		
		
		pack();
		this.setTitle("JDialogExample");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
	}

	public Font getFont() {
		font = new Font(type1, type2, size );
		return font; // new Font();
	}
	public Color getColor()
	{
		return color;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn) {
			color = JColorChooser.showDialog(null, "색상 선택 화면", Color.black);
		}
		else if(e.getSource() == textcombo)
		{
			type1 = textcombo.getSelectedItem().toString();
		}
		else if(e.getSource() == sizecombo)
		{
			size = Integer.parseInt(sizecombo.getSelectedItem().toString());
		}
	
		UpdateExampleText();
	}
	
	private void UpdateExampleText()
	{
		font = new Font(type1, type2, size );
		exText.setFont(font);
		exText.setForeground(color);
		exText.setText(exTextString);
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
}
