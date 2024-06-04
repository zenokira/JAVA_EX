package CLASS;

import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ids = new String[100];
		String[] pws = new String[100];
		int count = 0;

		do {
			System.out.println(" n : 회원 수 보기");
			System.out.println(" s : 회원가입");
			System.out.println(" l : 로그인 하기");
			System.out.println(" c : 비밀번호 변경 하기");
			System.out.println(" e : 종료하기");

			System.out.print("원하는 메뉴 글자 ( n , s , l , e , c) 중 하나를 입력하세요:");

			Scanner sc = new Scanner(System.in);
			char menuChar = sc.next().charAt(0);

			switch (menuChar) {
			case 'n':
				System.out.println("현재 가입된 회원 수는 " + count + "명 입니다.");
				break;
			case 'c':
				break;
			case 's':
				count = SignUp(ids, pws, count);
				break;
			case 'l':
				Login(ids, pws, count);
				break;
			case 'e':
				System.out.println("시스템을 종료합니다.");
				return;
			}
		} while (true);

	}

	public static int SignUp(String[] ids, String[] pws, int count) {
		System.out.print("등록하고자 하는 아이디를 입력해주세요 : ");

		Scanner sc = new Scanner(System.in);
		String userID = sc.nextLine();

		for (int i = 0; i < count; i++) {
			if (userID.equals(ids[i])) {
				System.out.println("해당 아이디는 이미 가입된 아이디입니다.");
			}
		}
		System.out.print("등록하고자 하는 패스워드를 입력해주세요 : ");
		String userPW = sc.nextLine();

		ids[count] = userID;
		pws[count] = userPW;
		count++;
		return count;
	}

	public static void Login(String[] ids, String[] pws, int count) {

		System.out.print("아이디를 입력해주세요 : ");
		Scanner sc = new Scanner(System.in);
		String userID = sc.nextLine();

		System.out.print("패스워드를 입력해주세요 : ");
		String userPW = sc.nextLine();
		
		int i = 0;
		int flag = 0;
		
		for (i = 0; i < count; i++) {
			if (userID.equals(ids[i])) {
				flag = 1;
				if(userPW.equals(pws[i]))
				{
					flag = 2;
				}
				break;
			}
		}

		if ( flag == 0 ) System.out.println("아이디가 일치하지 않습니다.");
		else if ( flag == 1 ) System.out.println("패스워드가 일치하지 않습니다.");
		else if ( flag == 2 ) {
			System.out.println("아이디 패스워드 모두 일치합니다.");
			SeatReservation.start(null);
		}
	}

}
