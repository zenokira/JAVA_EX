package CONSTRUCTOR;

public class MyRectangleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRectangle r1 = new MyRectangle();
		MyRectangle r2 = new MyRectangle(new MyPoint(3,3), 5, 6);
		MyRectangle r3 = new MyRectangle(3,3,6,6);
		
		System.out.println("r1 면적은 " + r1.getArea() + "입니다.");
		System.out.println("r2 면적은 " + r2.getArea() + "입니다.");
		System.out.println("r3 면적은 " + r3.getArea() + "입니다.");
	}

}

class MyPoint{
	private int x, y;
	
	public MyPoint() { this(0,0); }
	public MyPoint(int a , int b) { this.x = a; this.y = b; }
	
	public int getX() {return x;}
	public void setX(int newX) {x = newX;}
	public int getY() {return y;}
	public void setY(int newY) {y = newY;}
}

class MyRectangle{
	private MyPoint corner;
	private int width, height;
	
	public MyRectangle()
	{
		this(new MyPoint(0,0),0 ,0 );
	}
	
	public MyRectangle(MyPoint p , int w, int h) {
		corner = p;
		width = w; height = h;
	}
	
	public MyRectangle(int x, int y, int w, int h)
	{
		corner = new MyPoint(x,y);
		width = w; height = h;
	}
	
	public MyPoint getPoint() { return corner;}
	public void setPoint(MyPoint newP) { corner = newP;}
	public int getWidth() { return width;}
	public void setWidth(int newW) { width = newW;}
	public int getHeight() { return height;}
	public void setHeight(int newH) { height = newH; }
	
	public void resize(int newW, int newH) {width = newW; height = newH; }
	public int getArea() { return width * height;}
	
}