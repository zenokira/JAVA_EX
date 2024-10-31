package Graphic;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FontDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Font Demo");
		frame.setSize(1000,500);
		myComponent comp = new myComponent();
		frame.add(comp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class myComponent extends JPanel
{
	public void paintComponent(Graphics g)
	{
		Font font = g.getFont();
		String msg = font.getFontName() + ", " + font.getSize();
		
		g.drawString(msg, 100, 100);;
		
		font = new Font("SansSerif", Font.BOLD, 16);
		g.setFont(font);
		msg = g.getFont().getFontName() + ", " + font.getSize();
		g.drawString(msg, 200, 200);
		
		font = new Font("Serif",Font.ITALIC,12);
		g.setFont(font);
		msg = g.getFont().getFontName() + ", " + font.getSize();
		g.drawString(msg, 300, 300);
	}
}
