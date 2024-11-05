package 그림판;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener{

	Point startPt;
	
	
	public interface MouseEv{
		void MouseUp();
	}
	
	MouseEv someEvent;
	BufferedImage mainImg;
	
	
	
	
	
	
	public MyPanel(Dimension d)
	{
		setPreferredSize(d);

		int width = (int)d.getWidth();
		int height = (int)d.getHeight();
		mainImg = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB);
		mainImg.getGraphics().fillRect(0, 0, 300, 300);
		this.addMouseListener(this);
		
	}

	public void setEvent(MouseEv mouseEv)
	{
		this.someEvent = mouseEv;
	}
	
	
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		startPt = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "도형");
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
