package String_ex;

public class ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String abc = "abcdefg";
		String a1 = abc.substring(2,4);
		String a2 = abc.concat(a1);
		System.out.println(a2);
		
		String regExp = " |,|:|\\.";
		String words = "one two,three:four.five";
		String newStr = words.replaceAll(regExp, "-");
		System.out.println(newStr);
	}

}
