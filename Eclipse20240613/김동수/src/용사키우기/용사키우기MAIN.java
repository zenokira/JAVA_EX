package ���Ű���;

import java.util.Random;
import java.util.Scanner;

public class ���Ű���MAIN {
	private ��� player;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		���Ű���MAIN st = new ���Ű���MAIN();
		st.Start();
	}
	
	void Start() {
//		Intro();
		
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		Initialize(name);
		
		System.out.println(player.getName() + "�� ������ �����մϴ�.");
				
		while ( true )
		{
			Random rand = new Random();
			int r = 1; //rand.nextInt() % 4 + 1; 
			
			switch ( r )
			{
			case 1: // ������ �߰�
				player.���();
				System.out.println();
				int id = rand.nextInt(1) + 1;
				int n = rand.nextInt(2) + 1;
				String Iname = "����";
				
				������ item = new ������(Iname,id,n);
				item.�����ۺ��̱�();
				
				System.out.println("�������ּ��� ( 1. ȹ�� , 2. ���� )");
				int choice = sc.nextInt();
				
				if ( choice == 1) player.setItem(item);
				else 
				{
					System.out.println("�������� �����ߴ�.");
					player.inventory.showItem ();
				}
				
				
				
				break;
			case 2: // ���� �߰�
				break;
			case 3: // ���� �߰�
				break;
			case 4: // ���ռ��� ���� �ȴ´�.
				break;
			
			}
		}
	}
	
	void Initialize(String name)
	{
		player = new ���(name);
	}
	
	void Intro()
	{
		System.out.println("-���ձ��� ��ġ���̴� ��簡 �ܸ����� ����� ������-");
		sleep(2000);
		System.out.println("-�׿� �Բ� ���� �Ѹ��� ���� �������� ��������-");
		sleep(2000);
		System.out.println("���� : I will be back");
		sleep(2000);
		System.out.println("-������ �������� ���ձ��� �����߰�-");
		sleep(2000);
		System.out.println("-666���� �귶��-");
		sleep(2000);
		System.out.println("-��ȭ�Ӵ� ��� ������ �ϴÿ��� ������ ���� ������ �� ������� ���� �ɾ���-");
		sleep(2000);
		System.out.println("����� �̸��� �����ΰ���? ");
	}
	
	void sleep(int m)
	{
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}