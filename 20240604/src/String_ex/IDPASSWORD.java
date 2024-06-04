package String_ex;

import java.util.Scanner;

public class IDPASSWORD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 : ");
		String login = sc.next();
		System.out.println("패스워드 : ");
		String password = sc.next();
		
		login = login.trim();
		password = password.trim();
		
		login = login.toLowerCase();
		password = password.toLowerCase();
		
		if (login.equals("bmkim")) {
			if(password.equals("koala")) {
				System.out.println("아아디 패스워드 전부 일치합니다.");
			}
			else
				System.out.println("패스워드가 일치하지 않습니다.");
		}
		else
		{
			System.out.println("아이디가 일치하지 않습니다.");
		}
		

	}

}
