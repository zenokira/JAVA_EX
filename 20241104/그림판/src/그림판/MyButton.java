package 그림판;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import 그림판.Main그림판.DiagramType;
import 그림판.Main그림판.BtnType;

public class MyButton extends JButton {

	private BtnType btnType; // 색상, 도형, 도구
	
	private Color color;
	private DiagramType diaType; // 직선, 원, 사각형, 삼각형
	private int toolType;
	
	public MyButton() 
	{
		
	}
		
	public void setMybtnSize(int n)
	{
		Dimension D = new Dimension();
		D.setSize(n,n);
		setPreferredSize(D);
	}
	
	public MyButton(Dimension d) 
	{
		setPreferredSize(d);
	}
	
	public MyButton(BtnType _btnType)
	{
		btnType = _btnType;
	}
	public MyButton(DiagramType _diaType)
	{
		diaType = _diaType;
	}
	public MyButton(int _toolType)
	{
		toolType = _toolType;
	}
	
	
	

	public Color getColor() {
		return color;
	}

	public void setColor(Color _color) {
		this.color = _color;
		this.setBackground(color);
	}

	public int getToolType() {
		return toolType;
	}

	public void setToolType(int _toolType) {
		this.toolType = _toolType;
	}

	public BtnType getBtnType() {
		return btnType;
	}

	public void setBtnType(BtnType _btnType) {
		this.btnType = _btnType;
	}

	public DiagramType getDiaType() {
		return diaType;
	}

	public void setDiaType(DiagramType _diaType) {
		this.diaType = _diaType;
	}
}
