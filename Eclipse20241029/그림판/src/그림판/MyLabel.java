package 그림판;

import java.awt.Color;

import javax.swing.JLabel;

public class MyLabel extends JLabel{

	private Color color = new Color(0);
	
	public MyLabel()
	{
		
	}
	
	public MyLabel(Color _color)
	{
		setColor(_color);
		this.setBackground(getColor());
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		this.setBackground(color);
	}
}
