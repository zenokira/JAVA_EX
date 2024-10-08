package JFrame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame("title");
		Container c = f.getContentPane();
		JButton b = new JButton("press me");
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("press me");
			}
		});
		
		c.add(b);
		
		f.setSize(200,200);
		f.setLocation(300,300);
		f.setVisible(true);
	}
	
	public JFrameTest()
	{
		super("test");
	}

}
