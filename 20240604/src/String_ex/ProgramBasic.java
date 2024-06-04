package String_ex;

public class ProgramBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1, str2, str3, str4, str5;
		
		char[] charArray = { 'I', ' ', 'L','O','V','E',' ','Y','O','U'};
		
		str1 = "Hi, Byeong Man";
		str2 = new String(str1);
		str3 = new String(charArray);
		str4 = new String(charArray,2,4);
		
		System.out.println(str1 + str2 + str3 + str4);
	}

}
