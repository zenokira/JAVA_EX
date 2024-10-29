package Dialog;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ColorChooserDemo extends JFrame implements MouseListener{

	JLabel testLabel;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorChooserDemo f = new ColorChooserDemo("test");
	}

	public ColorChooserDemo(String title)
	{
		super(title);
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		
		testLabel = new JLabel("Click Here");
		c.add(testLabel);
		testLabel.setBackground(Color.YELLOW);
		testLabel.setOpaque(true);
		testLabel.addMouseListener(this);
		setSize(200,200);
		
		setSize(200,200);
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Color c = JColorChooser.showDialog(null, "글자색 선택화면", Color.RED);
		if(c!= null)
			testLabel.setForeground(c);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
