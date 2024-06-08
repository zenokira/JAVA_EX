package TEST;

import java.util.Scanner;

public class 구단 {
	private String name;

	private 코치[] coach = new 코치[10];
	private 선수[] player = new 선수[10];

	private int 코치_count, 선수_count;

	public void setName(String str) {
		this.name = str;
	}

	@Override
	public String toString() {
		return this.name;
	}

	/*
	 * public String getName() { return this.name; }
	 */
	void 구단edit() {

		while (true) {
			System.out.println("<<" + this.name + "을 편집합니다.>>");
			System.out.println("1. 코치 추가");
			System.out.println("2. 선수 추가");
			System.out.println("3. 코치 삭제");
			System.out.println("4. 선수 삭제");
			System.out.println("5. 나가기");

			System.out.println("입력 : ");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			sc.nextLine();
			
			if(n == 5) break;
			
			if(n > 0 && n < 5) 구단편집(n);
			else System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
		}
	}

	void 구단편집(int n) {
		switch (n) {
		case 1:
			코치추가();
			break;
		case 2:
			선수추가();
			break;
		case 3:
			코치삭제();
			break;
		case 4:
			선수삭제();
			break;
		case 5:
			return;
		}
	}

	void 코치추가() {
		System.out.print("코치이름을 입력해주세요 : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		코치 newCoach = new 코치();
		newCoach.setName(str);
		coach[코치_count] = newCoach;

		System.out.println("> " + coach[코치_count] + "가 추가되었습니다.");

		코치_count++;
	}

	void 선수추가() {
		System.out.println("<<<선수를 추가합니다.>>>");
		System.out.print("선수이름 : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();

		System.out.print("선수연봉(만원) : ");
		int pay = sc.nextInt();
		sc.nextLine();

		선수 newPlayer = new 선수();
		newPlayer.setPlayer(name, pay);
		player[선수_count] = newPlayer;

		System.out.println("> " + player[선수_count] + "가 추가되었습니다.");

		선수_count++;
	}

	void 구단정보() {
		System.out.println("<<" + name + ">>");

		코치정보();
		선수정보();
		
	}
	
	void 코치정보()
	{
		System.out.println("[코치 정보]");
		for (int i = 0; i < 코치_count; i++) {
			System.out.println((i + 1) + ". " + coach[i]);
		}
		System.out.println();
	}
	
	void 선수정보()
	{
		System.out.println("[선수 정보]");
		for (int i = 0; i < 선수_count; i++) {
			System.out.println((i + 1) + ". " + player[i] + " : " + player[i].getPay() + "(만원)");
		}
		System.out.println();
	}
	
	void 코치삭제() {
		코치정보();
		
		System.out.print("삭제하고자 하는 코치번호를 입력해주세요 : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()-1;
		sc.nextLine();
		
		coach[n].delete();
		코치정렬(n);
	}
	
	void 코치정렬(int n)
	{
		코치_count--;
		int i;
		for ( i = n; i < 코치_count; i++ )
		{
			coach[i] = coach[i+1];
		}
		coach[코치_count] = null;
	}
	
	void 선수삭제() {
		선수정보();
		
		System.out.print("삭제하고자 하는 선수번호를 입력해주세요 : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()-1;
		sc.nextLine();
		
		player[n].delete();
		선수정렬(n);
	}
	
	void 선수정렬(int n)
	{
		선수_count--;
		int i;
		for ( i = n; i < 선수_count; i++ )
		{
			player[i] = player[i+1];
		}
		player[선수_count] = null;
	}
	
	public void delete()
	{
		
		for ( int i = 0; i < 코치_count; i++)
		{
			coach[i].delete(null);
			coach[i] = null;
		}
		for ( int i = 0; i < 선수_count; i++)
		{
			player[i].delete(null);
			player[i] = null;
			
		}
		
		coach = null;
		player = null;
		
		System.out.println("> " + name + " 구단이 삭제되었습니다.");
		name = null;

	}
	
	
}
