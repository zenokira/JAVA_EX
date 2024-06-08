package 포장;

public class BoxingUnBoxingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val = 30;
		Integer iOb = Integer.valueOf(val);
		Integer jOb = val;
		
		System.out.println(val + " " + (iOb+val) + " " + jOb);
		
		Integer ob = new Integer(5);
		int i = ob.intValue();
		int j = ob;
		
		System.out.println(ob + " " + i +" " + j);
		
		
		int a = 123;
		Integer o = a;
		System.out.println(a+o);
	}

}
