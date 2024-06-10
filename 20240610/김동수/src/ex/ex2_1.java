package ex;

public class ex2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * shape s = new Rectangle(1,2); s.calcArea(); System.out.println(s.area +
		 * "..");
		 */
		
		/*
		 * Circle c = new Circle(5);
		 * 
		 * c.calcArea();
		 * 
		 * System.out.println(c.area + "..");
		 */
		
		/*
		 * Square sq = new Square(5);
		 * 
		 * sq.calcArea();
		 * 
		 * System.out.println(sq.area + "..");
		 */
		shape s = new Rectangle(1,2);
		Circle c = new Circle(5);
		Square sq = new Square(5);
		
		s.calcPerimeter();
		c.calcPerimeter();
		sq.calcPerimeter();
		
		System.out.println(s.per + "..");
		System.out.println(c.per + "..");
		System.out.println(sq.per + "..");
	}

}

class shape {
	public int area;
	public int per;
	
	void calcArea() {
		
	}
	void calcPerimeter()
	{
		
	}
}

class Rectangle extends shape{
	int w, h;
	
	public Rectangle (int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	void calcArea()
	{
		area = w * h;
	}
	
	void calcPerimeter()
	{
		per = w + w + h + h;
	}
}
//2-1 1)
class Circle extends shape{
	int r;
	final double PI = 3.14;
	double area, per;
	
	
	public Circle(int r) {
		this.r = r;
	}
	
	void calcArea()
	{
		area = r * r * PI;
	}
	
	void calcPerimeter()
	{
		per = 2 * r * PI;
	}
}

class Square extends Rectangle{
	
	public Square ( int s )
	{
		super(s,s);
	}
	void calcPerimeter()
	{
		per = 4 * w;
	}
	
}