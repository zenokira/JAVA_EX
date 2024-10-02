package JFrame;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class examCardLayout extends JFrame implements ActionListener {
	JButton[] buttons;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		examCardLayout app = new examCardLayout("title");
	}

	public examCardLayout(String s) {
		super(s);
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		buttons = new JButton[5];
		
		Container c = getContentPane();
		c.setLayout(new CardLayout());
		
		for(int i = 0; i < 5; i++)
		{
			buttons[i] = new JButton("button " + (i+1) );
			buttons[i].addActionListener(this);
			c.add(buttons[i], "btn" + (i+1));
		}
		
		this.setSize(200, 200);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		Container c = getContentPane();
		CardLayout layout = (CardLayout) c.getLayout();
				
		if (event.getSource() == buttons[1]) {
			layout.last(c);
		}
		else if (event.getSource() == buttons[4]) {
			layout.previous(c);
		}
		else if (event.getSource() == buttons[3]) {
			layout.show(c, "btn1");
		}
		else {
			layout.next(c);
		}
	}

}
