package Mouse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Mouse.testMouse.MouseEventHandler;

public class MouseEventDemo extends JFrame {

	JLabel label1, label2;
	JButton button1;
	boolean flag = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseEventDemo app = new MouseEventDemo();
	}

	public MouseEventDemo() {
		super("test");
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		c.setLayout(null);

		label1 = new JLabel("Click Here");
		label1.setOpaque(true);
		label1.setBackground(Color.YELLOW);
		label1.setLocation(0, 0);
		label1.setSize(100, 50);
		c.add(label1);

		label2 = new JLabel("Click Here");
		label2.setOpaque(true);
		label2.setBackground(Color.YELLOW);
		label2.setLocation(0, 200);
		label2.setSize(100, 50);
		c.add(label2);

		button1 = new JButton("Me");
		button1.setOpaque(true);
		button1.setBackground(Color.GREEN);
		button1.setLocation(100, 100);
		button1.setSize(50, 50);
		c.add(button1);

		
		MouseEventHandler handlerObj = new MouseEventHandler();
		label2.addMouseListener(handlerObj);
		button1.addMouseMotionListener(handlerObj);
		this.addMouseListener(handlerObj);
		this.addMouseMotionListener(handlerObj);
		
		
		
		
		
		
		setSize(300, 300);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}

	public class MouseEventHandler implements MouseListener, MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			if(flag)
			{
			label1.setText("dragged " + e.getXOnScreen() + " , " + e.getYOnScreen());
			Point bx = button1.getLocation();
			button1.setLocation(bx.x+e.getX(), bx.y + e.getY());
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			label1.setText(e.getXOnScreen() + " , " + e.getYOnScreen());
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == label2)
			{
				label1.setText("Clicked : " + e.getX() + ", " + e.getY());
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
				flag = true;
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			flag = false;
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
