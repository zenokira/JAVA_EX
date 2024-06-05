package CALLBY;

import OVERLOADING.MyInteger;

public class ArgumentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3, y = 5;
		
		MyInteger ob1 = new MyInteger(),
				ob2 = new MyInteger();
		
		//swap(x,y);
		System.out.println("x = " + x + ", " + "y = " + y);
		ob1.setVal(3); ob2.setVal(5);
		//swap(ob1,ob2);
		System.out.println("ob1 = " + ob1.getVal() + ", " + "ob2 = " + ob2.getVal());
		
		int k = ob1.add(ob2);
		System.out.println(k);
	}

	public static void swap (int x, int y)
	{
		int tmp;
		
		tmp = x;
		x = y;
		y = tmp;
	}
	
	public static void swap(MyInteger x, MyInteger y)
	{
		int tmp;
		tmp = x.getVal();
		x.setVal(y.getVal());
		y.setVal(tmp);
	}
}
