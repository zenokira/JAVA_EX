package 상속;

public class ProgramBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle r;//1
		
		r = new Rectangle();//2
	}
}

class Shape {
	private int x, y;
	/*
	public Shape() { 
		this(0,0);
		System.out.println("Shape 생성자");
	}
	*/
	public Shape(int xloc, int yloc) { //7 
		x = xloc; y = yloc; //8
		System.out.println("Shape 유인 생성자"); //9
	}
	
	public void finalize() {
		System.out.println("Shape 소멸자");
	}
}

class Rectangle extends Shape { 
	private int width, height;
	
	public Rectangle() {//3
		this(0,0,0,0); //4
		System.out.println("Rectangle 생성자"); // 12
	}
	
	public Rectangle(int x, int y, int w, int h) { //5 
		super(x,y); //6
		width = w; height = h; // 10
		System.out.println("Rectangle 유인 생성자"); // 11
	}
	
	public void finalize() {
		System.out.println("Rectangle 소멸자");
	}
}
