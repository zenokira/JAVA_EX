package String_ex;

public class Split {
	public static void main(String [] args)
	{
		String delimStr = " |,|:|\\.";
		String words = "minus one  two,three:four.five";
		String[] split = null;
		split = words.split(delimStr);
		for (String s : split) System.out.println(s);
		
		String regExp = "01[078]-\\d{4}-\\d{4}";
		String Str = new String("010-5182-0173");
		System.out.println(Str.matches(regExp));
		
		Str = new String("013-5182-0173");
		System.out.println(Str.matches(regExp));
		
		Str = new String("013-518-0173");
		System.out.println(Str.matches(regExp));
	}
}
