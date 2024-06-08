package 상속;

public class Program2{
	public static void main(String[] args) {
		ParentClass obj = new ChildClass();
		obj.print();
	}
}


class ParentClass {
	public void print()
	{
		System.out.println("부모 클래스의 print() 멤버 함수");
	}
}

class ChildClass extends ParentClass {
	/*private int data = 10;*/
	@Override
	public void print()
	{
		super.print();
		System.out.println("자식 클래스의 print() 멤버 함수");
	}
	public void aaa()
	{
		System.out.println("함수");
	}
}
