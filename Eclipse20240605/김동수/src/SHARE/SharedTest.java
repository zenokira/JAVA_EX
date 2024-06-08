package SHARE;

public class SharedTest {

	private static int sharedVariable;
	public final static int sharedConstant = 100;

	public static int getSharedVariable() {
		return sharedVariable;
	}

	public static void setSharedVariable(int s) {
		sharedVariable = s;
	}

	public static void main(String[] args) {
		SharedTest app = new SharedTest();
		SharedTest.A ob1 = app.new A();
		ob1.updateData();
		SharedTest.B ob2 = app.new B();
		ob2.realData();
	}

	class A {
		public void updateData() {
			System.out.println("상수 : " + SharedTest.sharedConstant);
			SharedTest.setSharedVariable(5);
		}
	}

	class B {
		public void realData() {
			System.out.println("상수 : " + SharedTest.sharedConstant);
			System.out.println(SharedTest.getSharedVariable());
		}
	}

}
