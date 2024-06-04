package CLASS;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	private static String getString(String s1, String s2, String s3) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String input;
		Pattern pattern;
		Matcher m;
		
		while(true)
		{
			System.out.print(s1);
			input = sc.nextLine();
			pattern = Pattern.compile(s2);
			m = pattern.matcher(input);
			if(m.matches()) break;
			System.out.println(s3);
		}
		
		return input;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = getString("이름 : ", "^[가-힣]{2,4}$", "이름 형식에 맞지 않습니다. 다시 입력해주세요.");
		String addr = getString("주소 : ", "^[가-힣]{2,4}도\\s+[가-힣]{2,4}시\\s+[가-힣]{2,6}로\\s+\\d{2,4}$", "주소 형식에 맞지 않습니다. 다시 입력해주세요.");
		String post = getString("우편번호 : ", "^\\d{5}$", "우편번호 형식에 맞지 않습니다. 다시 입력해주세요.");
		String phone = getString("핸드폰 번호 : ", "^01[01]-\\d{4}-\\d{4}$", "핸드폰 번호 형식에 맞지 않습니다. 다시 입력해주세요.");
		String idnumber = getString("주민등록번호 : ", "^\\d{6}-[1-4]\\d{6}$", "주민등록번호 형식에 맞지 않습니다. 다시 입력해주세요.");
		String bloodtype = getString("혈액형 : ", "^[A,B,O,AB]{1,2}$", "혈액형 형식에 맞지 않습니다. 다시 입력해주세요.");
		String age = getString("나이 : ", "^\\d{1,3}$", "나이 형식에 맞지 않습니다. 다시 입력해주세요.");
		
		
		
		// 
		
		// 주민등록번호
		// 혈액형
		/*
		
		Scanner sc = new Scanner(System.in);
		String input;
		Pattern pattern;
		Matcher m;
		
		System.out.println("이름 : ");
		input = sc.nextLine();
		pattern = Pattern.compile("^[가-힣]{2,4}$");
		m = pattern.matcher(input);
		if ( !m.matches()) {
			System.out.println("이름 형식에 맞지 않습니다.");
			return ;
		}
		
		System.out.println("주소 : ");
		input = sc.nextLine();
		pattern = Pattern.compile("^[가-힣]{2,4}도\\s+[가-힣]{2,4}시\\s+[가-힣]{2,6}로\\s+\\d{2,4}$");
		m = pattern.matcher(input);
		if ( !m.matches()) {
			System.out.println("주소 형식에 맞지 않습니다.");
			return ;
		}
		
		System.out.println("우편번호 " );
		input = sc.nextLine();
		pattern = Pattern.compile("^\\d{5}$");
		m = pattern.matcher(input);
		if ( !m.matches()) {
			System.out.println("우편번호 형식에 맞지 않습니다.");
			return ;
		}
		
		System.out.println("핸드폰 번호 " );
		input = sc.next();
		pattern = Pattern.compile("^01[01]-\\d{4}-\\d{4}$");
		m = pattern.matcher(input);
		if ( !m.matches()) {
			System.out.println("핸드폰 번호 형식에 맞지 않습니다.");
			return ;
		}
		*/
		
		System.out.println("모든 자료를 형식에 맞게 입력하셨습니다.");
		System.out.println("이름 : "+ name);
		System.out.println("주소 : "+ addr);
		System.out.println("우편번호 : "+ post);
		System.out.println("전화번호 : "+ phone);
		System.out.println("주민등록번호 : "+ idnumber);
		System.out.println("혈액형 : "+ bloodtype);
		System.out.println("나이 : "+ age);
		
		
	}


}
