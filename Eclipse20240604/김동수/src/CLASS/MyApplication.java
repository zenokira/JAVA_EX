package CLASS;

public class MyApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRectangle ob1 = new MyRectangle();
		MyRectangle ob2 = new MyRectangle();
		
		ob1.x = 0; ob1.y = 0; ob1.width = 10; ob1.height=10;
		ob1.x = 5; ob1.y = 5; ob1.width = 15; ob1.height=10;
		
		System.out.println("위치 : " + ob1.x + ", " + ob1.y + " 폭 : " +ob1.width + " 높이 " + ob1.height);
		System.out.println("위치 : " + ob2.x + ", " + ob2.y + " 폭 : " +ob2.width + " 높이 " + ob2.height);
		
		ob1.origin.x = ob1.x; ob1.origin.y = ob1.y;
		
		ob1.f(0, 0);
	}

}
