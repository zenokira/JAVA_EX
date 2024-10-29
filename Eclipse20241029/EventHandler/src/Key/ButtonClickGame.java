package Key;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ButtonClickGame extends JFrame implements KeyListener, ActionListener {

	final int DELTABlue = 100, DELTARed = 10;
	int frameWidth, frameHeight;
	Random rand = new Random();
	Timer escapeTimer;

	JLabel blueLabel, redLabel;
	Point bluePoint, redPoint;
	JLabel positionLabel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ButtonClickGame app = new ButtonClickGame();
	}

	public ButtonClickGame() {
		super("game");
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		Container c = getContentPane();
		c.setLayout(null);

		this.addKeyListener(this);

		positionLabel = new JLabel();
		blueLabel = new JLabel(" ");
		redLabel = new JLabel(" ");

		blueLabel.setOpaque(true);
		redLabel.setOpaque(true);

		blueLabel.setSize(10, 10);
		blueLabel.setBackground(Color.BLUE);
		blueLabel.setLocation(0, 0);

		redLabel.setSize(10, 10);
		redLabel.setBackground(Color.RED);
		redLabel.setLocation(0, 10);

		positionLabel.setSize(200, 200);
		positionLabel.setLocation(500, 500);

		c.add(blueLabel);
		c.add(redLabel);
		c.add(positionLabel);

		setSize(507, 500);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		initializeGame();
	}

	private void initializeGame() {
		frameWidth = this.getSize().width;
		frameHeight = this.getSize().height;

		bluePoint = new Point(rand.nextInt(frameWidth), rand.nextInt(frameHeight));
		redPoint = new Point(rand.nextInt(frameWidth), rand.nextInt(frameHeight));

		blueLabel.setLocation(bluePoint);
		redLabel.setLocation(redPoint);

		escapeTimer = new Timer(1800, this);
		escapeTimer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		runAwayBlueLabel();
	}

	private void runAwayBlueLabel() {
		// TODO Auto-generated method stub
		int dir = rand.nextInt(4) + 1;
		switch (dir) {
		case 1:
			bluePoint.x -= DELTABlue;
			if (bluePoint.x < 0)
				bluePoint.x = 0;
			break;
		case 2:
			bluePoint.x += DELTABlue;
			int xlimit = frameWidth - blueLabel.getSize().width;
			if (bluePoint.x > xlimit)
				bluePoint.x = xlimit;
			break;
		case 3:
			bluePoint.y -= DELTABlue;
			if (bluePoint.y < 0)
				bluePoint.y = 0;
			break;
		case 4:
			bluePoint.y += DELTABlue;
			int ylimit = frameHeight - blueLabel.getSize().height;
			if (bluePoint.y > ylimit)
				bluePoint.y = ylimit;
			break;
		}

		blueLabel.setLocation(bluePoint);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (redPoint.y == 0)
				break;
			redPoint.y = redPoint.y - DELTARed;
			redLabel.setLocation(redPoint);
			break;

		case KeyEvent.VK_DOWN:
			if (redPoint.y >= frameHeight-redLabel.getHeight())
				break;
			redPoint.y = redPoint.y + DELTARed;
			redLabel.setLocation(redPoint);
			break;
		case KeyEvent.VK_LEFT:
			if (redPoint.x == 0)
				break;
			redPoint.x = redPoint.x - DELTARed;
			redLabel.setLocation(redPoint);
			break;

		case KeyEvent.VK_RIGHT:
			if (redPoint.x >= frameWidth - redLabel.getWidth())
				break;
			redPoint.x = redPoint.x + DELTARed;
			redLabel.setLocation(redPoint);
			break;
		}

		positionLabel.setText("red X : " + redPoint.x + ", Y :" + redPoint.y + "");

		if (isCatched()) {
			JOptionPane.showMessageDialog(null, "잡았습니다", "잡음!!!", JOptionPane.INFORMATION_MESSAGE);
			escapeTimer.stop();
		}

	}
	
	boolean isCatched()
	{
		Rectangle r1 = new Rectangle(redLabel.getLocation(), redLabel.getSize());
		Rectangle r2 = new Rectangle(blueLabel.getLocation(), blueLabel.getSize());
		if(r1.intersects(r2)) return true;
		else return false;
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
