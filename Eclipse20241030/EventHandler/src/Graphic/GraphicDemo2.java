package Graphic;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicDemo2 extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicDemo2 app = new GraphicDemo2();
	}

	public GraphicDemo2() {
		super("demo");
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());

		MyButton b = new MyButton();
		c.add(b);

		this.setSize(200, 200);
		this.setLocation(100, 100);
		this.setVisible(true);
	}

	class MyButton extends JButton implements ActionListener {
		boolean btnClicked = false;

		public MyButton() {
			addActionListener(this);
		}

		public Dimension getPreferredSize() {
			return new Dimension(50, 50);
		}

		public void paintComponent(Graphics graphics) {
			if (btnClicked == true) {
				super.paintComponent(graphics);
				graphics.setColor(new Color(255,0,0,255));
				graphics.fillOval((this.getWidth() / 2)-10, (this.getHeight() / 2)-10, 20, 20);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			btnClicked = true;
			repaint();
		}

	}
}
