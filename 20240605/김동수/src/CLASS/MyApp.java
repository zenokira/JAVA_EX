package CLASS;

public class MyApp {
	int x = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyTest ob = new MyTest();
//		
//		double result = ob.f(3, 4.5);
//		System.out.println(result);
		
//		MyInteger ob1 = new MyInteger(), ob2 = new MyInteger(), ob3 = new MyInteger();
//		ob1.val = 3; ob2.val = 5; ob3.val = 10;
//		
//		int x = ob1.add(ob3);
//		System.out.println(x);
//		int y = ob2.add(ob3);
//		System.out.println(y);
		
		/*
		 * StaticTest ob1 = new StaticTest(); StaticTest ob2 = new StaticTest();
		 * 
		 * ob1.setValue(3); System.out.println(ob2.getValue());
		 * 
		 * ob1.setInstVal(5); System.out.println(ob2.g);
		 */		
		
		
		
		
		StaticTest.setValue(3);
		System.out.println(StaticTest.getValue());

		StaticTest ob1 = new StaticTest();
		StaticTest ob2 = new StaticTest();
		
		ob1.setInstVal(5);
		System.out.println(ob2.getValue());
		
	}

}
