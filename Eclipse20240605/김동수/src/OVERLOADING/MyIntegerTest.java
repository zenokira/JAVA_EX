package OVERLOADING;

public class MyIntegerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyInteger ob = new MyInteger();
		int x = ob.add(5);
		double y = ob.add(3.5);
		System.out.println(x + ", " + y);
		ob.setVal(3);
		int t = ob.getVal();
		int k = ob.add(ob);
		System.out.println(k);
	}

}
