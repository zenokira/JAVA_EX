package INNER;

public class InnerTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Outer outer = new Outer();
		outer.Inner inner = outer.new Inner();
		inner.print();
	}
}

public class Outer{
	int num = 10;
	
	private class Inner{
		private int x = 5;
		public void print() {
			System.out.println("This is an inner class : " + num);
		}
	}
	
	void display_Inner() {
		Inner inner = new Inner();
		System.out.println(inner.x);
		inner.print();
	}
}