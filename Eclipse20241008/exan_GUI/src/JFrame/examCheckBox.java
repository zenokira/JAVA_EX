package JFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;


public class examCheckBox extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		examCheckBox start = new examCheckBox("체크박스 예제");
	}

	public examCheckBox(String s) {
		super(s);
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame();
		Container c = jf.getContentPane();
		MyItemListener listen = new MyItemListener();

		JButton jb	= new JButton("출력");
		JCheckBox chbox = new JCheckBox("고구마", false);

		c.setLayout(new FlowLayout());
		c.add(jb);
		c.add(chbox);
		
		jb.addActionListener(listen );
		chbox.addItemListener(listen);

		jf.setSize(400, 400);
		jf.setLocation(800, 300);
		jf.setVisible(true);
	}
}

class MyItemListener implements ActionListener, ItemListener {
	boolean flag = false;
	
	public void actionPerformed(ActionEvent e)
	{
		if(flag == true)
			System.out.println("press me");
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.SELECTED)
		{
			flag = !flag;
		}
		else
		{
			flag = !flag;
		}
	}
}
