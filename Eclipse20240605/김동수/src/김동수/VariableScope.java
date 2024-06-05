package 김동수;

public class VariableScope {
	int x = 3;
	
	public void method1()
	{
		int y = 5;
		System.out.println("x = " + x + "y = " + y);
	}
	
	public void method2(int y)
	{
		System.out.println("x = " + x + "y = " + y);
		int z;
		for (z = 0; z < 3; z++) System.out.println("z = " + z);
		System.out.println("z = " + z);
	}
}
