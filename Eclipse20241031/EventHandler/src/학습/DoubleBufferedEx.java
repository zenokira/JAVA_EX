package 학습;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DoubleBufferedEx extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DoubleBufferedEx();
	}

	public DoubleBufferedEx() {
		Container c = getContentPane();
		MyPanel jf = new MyPanel();
		c.add(jf);

		jf.setEvent(new MyPanel.MouseEv() {
			@Override
			public void MouseUp(Rectangle rect) {
				// TODO Auto-generated method stub
				System.out.println("x : " + rect.getX() + " y : " + rect.getY());
				System.out.println("width : " + rect.getWidth() + " Height : " + rect.getHeight());
			}
		});

		this.setLocation(20, 100);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

class MyPanel extends JPanel implements MouseListener {
	public interface MouseEv {
		void MouseUp(Rectangle rect);
	}

	MouseEv someEvent;
	BufferedImage mainImg;

	public MyPanel() {
		mainImg = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
		mainImg.getGraphics().fillRect(0, 0, 300, 300);
		this.addMouseListener(this);
	}

	public void setEvent(MouseEv mouseEv) {
		this.someEvent = mouseEv;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(mainImg, 0, 0, 300, 300, 0, 0, 300, 300, this);
	}

	Point startpt;

	public void mousePressed(MouseEvent e) {
		startpt = e.getPoint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Rectangle rect = getRectangle(startpt, e.getPoint());
		draw(rect);
	}
	
	private Rectangle getRectangle(Point pt1, Point pt2) {
		// TODO Auto-generated method stub
		sort2Point(pt1,pt2);
		
		return new Rectangle(pt1.x, pt1.y, pt2.x - pt1.x, pt2.y - pt1.y);
	}
	
	
	
	private void sort2Point(Point pt1, Point pt2)
	{
		if(pt2.getX() < 0 ) pt2.x = 0;
		if(pt2.getY() < 0 )	pt2.y = 0;
		
		if (pt2.getX() < pt1.getX()) {
			swap(pt1, pt2, true);
		}
		if (pt2.getY() < pt1.getY()) {
			swap(pt1, pt2, false);
		}
	}

	private void swap(Point pt1, Point pt2, boolean type) {
		if (type) {
			int t = pt2.x;
			pt2.x = pt1.x;
			pt1.x = t;
		} else {
			int t = pt2.y;
			pt2.y = pt1.y;
			pt1.y = t;
		}
	}

	private void draw(Rectangle rect) {
		Graphics g2d = (Graphics) mainImg.getGraphics();

		g2d.setColor(Color.orange);
		g2d.drawRect(rect.x, rect.y, rect.width, rect.height);

		g2d.setColor(Color.red);
		g2d.fillRect(rect.x, rect.y, rect.width, rect.height);
		g2d.drawImage(mainImg, 0, 0, 300, 300, this);

		int rgb = mainImg.getRGB(10, 20);
		Color co = new Color(rgb);
		mainImg.setRGB(100, 100, co.getRGB());

		someEvent.MouseUp(rect);
		repaint();
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
