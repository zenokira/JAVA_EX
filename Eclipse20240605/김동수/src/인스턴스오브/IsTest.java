package 인스턴스오브;

class Class1 {

}

class Class2 {

}

public class IsTest {

	static void test(Object o) {
		Class1 ob1;
		Class2 ob2;

		if (o instanceof Class1) {
			System.out.println("o is Class1");
			ob1 = (Class1) o;
		} else if (o instanceof Class2) {
			System.out.println("o is Class2");
			ob2 = (Class2) o;
		} else {
			System.out.println("o is neither Class1 nor Class2");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class1 c1 = new Class1();
		Class2 c2 = new Class2();
		
		test(c1);
		test(c2);
		test("a string");
	}

}
