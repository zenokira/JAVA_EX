package Graphic;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PixelDemo extends JFrame implements ActionListener{

	JPanel panel;
	JButton btn1, btn2;

	MyImage img;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PixelDemo app = new PixelDemo();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public PixelDemo()
	{
		super("test");
		initializeComponents();
		img = new MyImage(new File("winter2.jpg"));
		img.displayImage(panel);
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		btn1 = new JButton("회색 이미지로");
		btn1.addActionListener(this);
		c.add(btn1);
		
		btn2 = new JButton("이전 이미지로");
		btn2.addActionListener(this);
		c.add(btn2);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(1024,800));
		c.add(panel);
		
		this.setSize(1280,800);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btn1)
		{
			img.convert2Gray();
			img.displayImage(panel);
		}
		else if(e.getSource() == btn2)
		{
			img.convert2Binary();
			img.displayImage(panel);
		}
	
	}
}

class MyImage{
	BufferedImage img;
	int imageType = 1;
	
	public MyImage(File file)
	{
		try {
			img = ImageIO.read(file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void convert2Gray()
	{
		imageType = 2;
		
		int w = img.getWidth();
		int h = img.getHeight();
		
		int pixel, glevel;
		
		Color color, grayColor;
		int red,green,blue;
		
		for(int r = 0; r < h; r++)
		{
			for(int c = 0; c < w; c++)
			{
				color = new Color(img.getRGB(c, r));
				red = color.getRed();
				green = color.getGreen();
				blue = color.getBlue();
				glevel = (int) Math.sqrt((red*red+green*green+blue*blue)/3.0);
				grayColor = new Color(glevel,glevel,glevel);
				img.setRGB(c, red, grayColor.getRGB());
			}
		}
	}
	
	public void convert2Binary()
	{
		imageType = 3;
		
		convert2Gray();
		
		int w = img.getWidth();
		int h = img.getHeight();
		
		int pixel, glevel;
		double sum = 0.0;
		
		for(int r = 0; r < h; r++)
		{
			for(int c = 0; c < w; c++)
			{
				pixel = img.getRGB(c, r);
				glevel = pixel & 0xff;
				sum += glevel;
			}
		}
		
		int avg = (int) sum / (h*w);
		for(int r = 0; r < h; r++)
		{
			for(int c = 0; c < w; c++)
			{
				pixel = img.getRGB(c,r);
				glevel = pixel & 0xff;
				if(glevel > avg) img.setRGB(c, r, Color.WHITE.getRGB());
				else img.setRGB(c, r, Color.BLACK.getRGB());
			}
		}
	}
	
	public int getImageType() {return imageType;}
	public BufferedImage getImage() {return img;}
	
	public void displayImage(JPanel panel)
	{
		Graphics g = panel.getGraphics();
		int dx1 = 0; int dy1 = 0;
		int dx2 = panel.getWidth(); int dy2 = panel.getHeight();
		
		int sx1 = 0; int sy1 = 0;
		int sx2 = img.getWidth(); int sy2 = img.getHeight();
		
		g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
	}
}

