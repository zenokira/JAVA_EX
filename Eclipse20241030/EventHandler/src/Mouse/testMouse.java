package Mouse;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class testMouse extends JFrame {

	private JLabel statusBar;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		testMouse app = new testMouse();
		
	}
	
	public testMouse()
	{
		super("test");
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		statusBar = new JLabel();
		c.add(statusBar, BorderLayout.SOUTH);
		
		MouseEventHandler handlerObj = new MouseEventHandler();
		this.addMouseListener(handlerObj);
		this.addMouseMotionListener(handlerObj);
		
		setSize(300,300);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public class MouseEventHandler implements MouseListener, MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			statusBar.setText("Dragged at [" + e.getX() + "," + e.getY() + "]");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			statusBar.setText("Moved at [" + e.getX() + "," + e.getY() + "]");

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			statusBar.setText("Clicked at [" + e.getX() + "," + e.getY() + "]");

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			statusBar.setText("Pressed at [" + e.getX() + "," + e.getY() + "]");

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			statusBar.setText("Release at [" + e.getX() + "," + e.getY() + "]");

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			statusBar.setText("마우스 윈도우 안으로 들어옴");

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			statusBar.setText("마우스 윈도우 밖으로 나감");
		}

	}
	
	
	
	
	
	
	
	
	
	
	
}




