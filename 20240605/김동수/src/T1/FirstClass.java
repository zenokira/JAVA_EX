package T1;

import T2.ThirdClass;

public class FirstClass {
	private int field1;
	
	public void method1() {
		field1 = 3;
		System.out.println(field1);
	}
	public void method2() {
		System.out.println(field1);
	}
	
	public int getField1() { return field1;}
	public void setField1(int n) { field1 = n;}
	
	public static void main(String[] args)
	{
		ThirdClass ob3 = new ThirdClass();
		ob3.method4();
		FirstClass fc = new FirstClass();
		
		System.out.println(fc.getField1());
		
	}
	
}

class SecondClass{
	public void method3()
	{
		FirstClass ob = new FirstClass();
		ob.setField1(5);
	}
}
