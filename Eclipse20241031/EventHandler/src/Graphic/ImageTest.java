package Graphic;

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

public class ImageTest extends JFrame implements ActionListener{

	JPanel panel;
	JButton btn1, btn2;
	BufferedImage memImg;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageTest app = new ImageTest();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public ImageTest()
	{
		super("test");
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		btn1 = new JButton("이미지 생성");
		btn1.addActionListener(this);
		c.add(btn1);
		
		btn2 = new JButton("출력");
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
			try {
				BufferedImage img = ImageIO.read(new File("winter.jpg"));
				BufferedImage img2 = ImageIO.read(new File("winter2.jpg"));
				memImg = new BufferedImage(1024,800, BufferedImage.TYPE_INT_RGB);
				
				Graphics graphics = memImg.createGraphics();
				int dx1 = 0; int dy1 = 0;
				int dx2 = memImg.getWidth(); int dy2 = memImg.getHeight();
				
				int sx1 = 0; int sy1 = 0;
				int sx2 = img.getWidth(); int sy2= img.getHeight();
				
				graphics.drawImage(img, dx1, dy1, dx2,dy2,sx1+60,sy1,sx2,sy2,null);
				graphics.drawImage(img2, dx2 / 2, 0, dx2, dy2, img2.getWidth()/2 - 170, 0, img2.getWidth()-170,img2.getHeight(), null);

				Graphics g2 = panel.getGraphics();
				g2.drawImage(memImg, 0,0, null);
	/*			
				graphics.drawImage(img2, 600,0, img2.getWidth()/2,0,0,0,0,0,null);
				
				Graphics graphics2 = panel.getGraphics();
				dx1 = 0; dy1 = 0;
				dx2 = panel.getWidth(); dy2 = panel.getHeight();
				sx1 = 0; sy1 = 0;
				sx2 = img.getHeight(); sy2 = img.getHeight();
				*/
				
						
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}
		else
		{
			File outFile = new File("myImage.jpg");
			
			try {
				ImageIO.write(memImg,"jpg", outFile);
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}
	
	}

}
