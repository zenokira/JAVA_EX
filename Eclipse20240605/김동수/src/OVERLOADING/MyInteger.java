package OVERLOADING;

public class MyInteger {
	int val;
	private int x;
	public int getVal() { return x;}
	public void setVal(int val) { x = val;}
	
	public int add(MyInteger ob) { 
		System.out.println("aa");
		return this.val + ob.val;
	}
	int add(int i) { return this.val + i;}
	double add(double d) { return this.val + d;}
	int subtract(MyInteger ob) { return this.val - ob.val;}
	int multiply(MyInteger ob) { return this.val * ob.val;}
	double divide(MyInteger ob) { return ((double)this.val) / ob.val;}
	
	
}
