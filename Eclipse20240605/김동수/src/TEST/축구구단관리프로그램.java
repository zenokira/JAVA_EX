package TEST;

import java.util.Scanner;

public class 축구구단관리프로그램 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		축구구단관리프로그램 st = new 축구구단관리프로그램();
		st.start();
	}

	private 구단[] team = new 구단[100];
	private int count;

	void start() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			프로그램Display();
			System.out.println("입력 : ");
			int n = sc.nextInt();
			sc.nextLine();
			switch (n) {
			case 1:
				구단추가();
				break;
			case 2:
				구단편집();
				break;
			case 3:
				break;
			case 4:
				구단보기();

				break;
			case 5:
				System.out.println("> 프로그램이 종료되었습니다.");
				return;
			default:
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	public void 프로그램Display() {
		System.out.println("<축구구단 관리 프로그램>");
		System.out.println("1. 구단 추가");
		System.out.println("2. 구단 편집");
		System.out.println("3. 구단 삭제");
		System.out.println("4. 구단 보기");
		System.out.println("5. 프로그램 종료");
	}

	void 구단추가() {
		System.out.println("<<구단추가>>");
		System.out.print("구단이름 입력 : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		for (int i = 0; i < count; i++) {
			if (str.equals(team[i])) {
				System.out.println("같은 이름의 구단이 존재합니다.");
			}
		}

		System.out.println("> 구단이 생성되었습니다.");
		구단 newTeam = new 구단();
		newTeam.setName(str);
		team[count] = newTeam;
		count++;
	}

	public void 구단리스트() {
		int i;
		for (i = 0; i < count; i++) {
			System.out.println((i + 1) + ". " + team[i]);
		}
		System.out.println((i + 1) + ". 나가기");
	}

	int 구단선택() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		return n - 1;
	}

	void 구단편집() {
		while (true) {
			구단리스트();
			System.out.print("편집할 구단 입력 : ");
			int choice = 구단선택();

			if(choice == count) break;
			if (choice > count || choice < 0)
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");

			team[choice].구단edit();
		}

	}

	void 구단보기() {
		구단리스트();
		System.out.println("구단을 선택하세요 : ");
		int n = 구단선택();
		team[n].구단정보();
		System.out.println();
	}
}
