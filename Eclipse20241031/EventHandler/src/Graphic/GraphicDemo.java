package Graphic;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicDemo extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicDemo app = new GraphicDemo();
	}

	public GraphicDemo()
	{
		super("demo");
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = this.getContentPane();
		
		MyJPanel panel = new MyJPanel();
		panel.setBackground(Color.yellow);
		
		c.setLayout(new FlowLayout());
		c.add(panel);
		
		this.setSize(200,200);
		this.setLocation(100,100);
		this.setVisible(true);
	}
	
	class MyJPanel extends JPanel implements MouseListener
	{
		private int x1, y1,x2,y2;
		
		public MyJPanel()
		{
			addMouseListener(this);
		}
		
		public Dimension getPreferredSize()
		{
			return new Dimension(150,100);
		}

		public void paintComponent(Graphics graphics)
		{
			super.paintComponent(graphics);
			graphics.fillOval(x1, y1, x2 - x1, y2 - y1);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			x1 = e.getX();
			y1 = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			x2 = e.getX();
			y2 = e.getY();
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

	
}
