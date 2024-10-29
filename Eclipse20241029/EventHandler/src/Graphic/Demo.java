package Graphic;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demo extends JFrame implements ActionListener {

	MyJPanel panel;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo app = new Demo();
	}

	public Demo() {
		super("test");
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		panel = new MyJPanel();
		panel.setBackground(Color.yellow);
		c.setLayout(new FlowLayout());
		c.add(panel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Graphics g = panel.getGraphics();
		g.setColor(Color.yellow);
		g.drawOval(30, 30, 100, 100);
		panel.repaint();
		
	}

	class MyJPanel extends JPanel {

		public void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);

			int[] xPoints = new int[5];
			int[] yPoints = new int[5];
			
			xPoints[0] = 70; yPoints[0] = 90;
			xPoints[1] = 100; yPoints[1] = 70;
			xPoints[2] = 130; yPoints[2] = 90;
			xPoints[3] = 130; yPoints[3] = 130;
			xPoints[4] = 70; yPoints[4] = 130;
			
			Color fillColor = new Color(255,0,0,255);
			graphics.setColor(fillColor);
			graphics.fillRect(0, 0, 60, 60);
			graphics.fillPolygon(xPoints,yPoints, 5);
			graphics.fillOval(140, 0, 60, 60);
			graphics.fillArc(210, 0, 60, 60, 90, 90);
			
			graphics.setColor(new Color(0,0,255,255));
			graphics.drawRect(0, 70, 60, 60);
			graphics.drawLine(70,0,130,60);
			graphics.drawOval(140, 70, 60, 60);
			graphics.drawArc(210, 70, 60, 60, 90, 90);
		}

		public Dimension getPreferredSize() {
			return new Dimension(250, 200);
		}
	}
}
