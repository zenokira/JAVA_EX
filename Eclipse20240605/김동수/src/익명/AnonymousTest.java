package 익명;

interface Greeting {
	String message();
}

public class AnonymousTest {
	public void display(Greeting g) {
		System.out.println(g.message());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnonymousTest ob = new AnonymousTest();
		
		ob.display(new Greeting() {
				public String message() {return "안녕하세요";}	
				}
		);
	
	}

/*
 * MyInterface inner = new MyInterface() { public void test() {
 * System.out.println("테스트입니다."); } }; inner.test();
 */
}

interface MyInterface {
	public void test();
}
/*
 * class MyClass implements MyInterface{ public void test() {
 * System.out.println("테스트입니다."); } }
 */