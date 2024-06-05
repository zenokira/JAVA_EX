package INNER;

public class InnerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer outer = new Outer();
		
		outer.display_Inner();
	}
}

class Outer{
	int num = 10;
	
	private class Inner{
		public void print() {
			System.out.println("This is an inner class : " + num);
		}
	}
	
	void display_Inner() {
		Inner inner = new Inner();
		inner.print();
	}
}
