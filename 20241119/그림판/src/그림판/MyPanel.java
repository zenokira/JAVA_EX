package 그림판;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener{

	Point startPt;
	MouseEv someEvent;
	BufferedImage mainImg;
	Graphics graphic;
	private Color Origin;
	private int Width, Height;

	public interface MouseEv{
		void MouseUp(Graphics graphic, Point start, Point end);
		void MouseDrag(Graphics graphic, Point pt);
		void MouseDown(Graphics graphic, Point pt);
	}
	
	public MyPanel(Dimension d, Color[] c, int strokeSize)
	{
		setPreferredSize(d);

		setWidth((int)d.getWidth());
		setHeight((int)d.getHeight());
		mainImg = new BufferedImage( getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		graphic = mainImg.getGraphics();
		graphic.setColor(Color.white);
		graphic.fillRect(0, 0, getWidth(), getHeight());
		setOrigin(graphic.getColor());	
		((Graphics2D)graphic).setStroke(new BasicStroke(strokeSize));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	public BufferedImage getBufferImage()
	{
		return mainImg;
	}
	
	public void setStroke(Stroke stroke)
	{
		((Graphics2D)graphic).setStroke(stroke);
	}
	
	public Stroke getStrkoe()
	{
		return ((Graphics2D)graphic).getStroke();
	}	

	public void setEvent(MouseEv mouseEv)
	{
		this.someEvent = mouseEv;
	}
	
	public void Invalidate() {
		// TODO Auto-generated method stub
		repaint();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(mainImg, 0, 0, Width,Height,0,0,Width,Height,this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		startPt = e.getPoint();
		someEvent.MouseDown(graphic,e.getPoint());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		someEvent.MouseUp(graphic,startPt,e.getPoint());

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		someEvent.MouseDrag(graphic, e.getPoint());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public Color getOrigin() {
		return Origin;
	}

	public void setOrigin(Color origin) {
		Origin = origin;
	}

	public int getWidth() {
		return Width;
	}

	public void setWidth(int width) {
		Width = width;
	}

	public int getHeight() {
		return Height;
	}

	public void setHeight(int height) {
		Height = height;
	}


	public void setClearImage()
	{
		graphic.setColor(Color.white);
		graphic.fillRect(0, 0, getWidth(), getHeight());
	}
}

