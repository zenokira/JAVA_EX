package String_ex;

public class String_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("I LOVE YOU");
		String str2 = new String("I HATE YOU");
		
		if(str1.startsWith("st")) System.out.println("st 로 시작합니다.");
		if(str2.startsWith("st")) System.out.println("st 로 시작합니다.");
		
		String str3 = "abcisabcisabc";
		
		System.out.println(str3.indexOf("abc"));
		System.out.println(str3.indexOf('i'));
		System.out.println(str3.indexOf('i',4));
		System.out.println(str3.lastIndexOf("abc"));
		System.out.println(str3.lastIndexOf('s'));
		System.out.println(str3.lastIndexOf('s',8));
	}

}
