package main;

public class 용사키우기MAIN {
	private 용사 player;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		용사키우기MAIN st = new 용사키우기MAIN();
		st.Start();
	}
	
	void Start() {
//		Intro();
		
		String name = 시스템.getInputString();
		
		Initialize(name);
		
		System.out.println(player.getName() + "의 모험을 시작합니다.");
				
		while ( true )
		{
			int r = 시스템.getRandInt(4) + 1;
			switch ( r )
			{
			case 1: // 아이템 발견
				player.아이템발견();
				break;
			case 2: // 몬스터 발견
				player.몬스터발견();
				break;
			case 3: // 마을 발견
				break;
			case 4: // 마왕성을 향해 걷는다.
				break;
			
			}
		}
	}
	
	void Initialize(String name)
	{
		
		player = new 용사(name);
	}
	
	void Intro()
	{
		System.out.println("-마왕군과 대치중이던 용사가 단말마의 비명을 질렀다-");
		sleep(2000);
		System.out.println("-그와 함께 마왕 한마디 말을 내뱉으며 쓰러졌다-");
		sleep(2000);
		System.out.println("마왕 : I will be back");
		sleep(2000);
		System.out.println("-마왕이 쓰러지자 마왕군은 후퇴했고-");
		sleep(2000);
		System.out.println("-666년이 흘렀다-");
		sleep(2000);
		System.out.println("-평화롭던 어느 마을에 하늘에서 강렬한 빛이 내려와 한 사람에게 말을 걸었다-");
		sleep(2000);
		System.out.println("당신의 이름은 무엇인가요? ");
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