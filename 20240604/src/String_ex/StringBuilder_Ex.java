package String_ex;

public class StringBuilder_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder s1,s2,s3;
		
		s1 = new StringBuilder();
		s2 = new StringBuilder(10);
		s3 = new StringBuilder("hello");
		
		System.out.println(s1.capacity());
		System.out.println(s2.capacity());
		System.out.println(s3.capacity());
			
		
	}
}
