package Key;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class KeyEventDemo extends JFrame implements KeyListener{

	JButton button1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyEventDemo app = new KeyEventDemo();
	}
	
	public KeyEventDemo()
	{
		super("test");
		initializeComponents();
	}
	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		c.setLayout(null);

		button1 = new JButton("This 1");
		button1.setOpaque(true);
		button1.setBackground(Color.GREEN);
		button1.setLocation(100,200);
		button1.setSize(100,100);
		c.add(button1);
		
		button1.addKeyListener(this);
		

		setSize(300, 300);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Point bpoint = new Point();
		JButton bt = (JButton) e.getSource();
		bt.getLocation(bpoint);
		
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			bpoint.x -= 10;
			break;
		case KeyEvent.VK_RIGHT:
			bpoint.x += 10;
			break;
		case KeyEvent.VK_UP:
			bpoint.y -= 10;
			break;
		case KeyEvent.VK_DOWN:
			bpoint.y += 10;
			break;
		}
		
		bt.setLocation(bpoint);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
