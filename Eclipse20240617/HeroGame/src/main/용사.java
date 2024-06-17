package main;

import java.util.Scanner;

public class 용사 extends 사람 implements 상태이상, 감정표현 {

	용사() {

	}

	용사(String name) {
		this.name = name;
		Initialize();
	}

	public void Initialize() {
		status = new 스탯();
		inventory = new 소지품();
	}

	public void 아이템획득(아이템 item) {
		inventory.아이템획득(item);
	}

	public 스탯 get스탯() {
		return status;
	}

	public void 인벤토리보기() {
		inventory.showItem();
	}

	void 아이템발견() {
		아이템 item = 시스템.랜덤아이템생성();
		item.아이템정보보이기();

		System.out.println("선택해주세요 ( 1. 획득 , 2. 포기 ) : ");
		int choice = 시스템.getInputInt();

		if (choice == 1)
			아이템획득(item);
		else {
			System.out.println("아이템을 포기했다.");
		}

	}

	public void 몬스터발견() {
		// TODO Auto-generated method stub
		몬스터 mon = new 몬스터();
		mon.랜덤몬스터생성();

		System.out.println("몬스터를 발견했다!!!!");
		mon.상태창보기();

		System.out.println("선택해주세요 ( 1. 싸운다 , 2. 도망간다 ) : ");
		int choice = 시스템.getInputInt();

		if (choice == 1) {
			배틀시작(mon);
		} 
		else {
			System.out.println("싸움을 포기했다.");
		}
	}

	void 배틀시작(몬스터 mon) {
			
		int turn = 1;
		boolean flag = true;
		
		while (flag) {
			if (turn % 2 == 1) 	flag = 용사턴(mon);
			else 				flag = 몬스터턴(mon); 
			turn++;
		}
	}
	
	boolean 용사턴(몬스터 mon)
	{
		System.out.println("선택해주세요 ( 1. 공격 , 2. 도망 ) : ");
		int choice = 시스템.getInputInt();
		boolean flag = true;
		switch (choice) {
		case 1:					
			용사의공격(mon);
			flag = mon.몬스터죽음여부();
			if ( flag ) 
			{
				System.out.println(mon.getName() + " 이(가) 쓰러졌습니다.");
				status.레벨업여부(mon) ;
				System.out.println("\n<배틀종료>\n");				
			}
			break;
		case 2: 
			System.out.println("성공적으로 도망쳤다");
		}
		return !flag;
	}
	
	void 용사의공격(몬스터 mon)
	{
		int dmg = status.물리데미지계산(mon.get물리방어력());
		mon.몬스터의피격(dmg);
	}
	
	
	
	boolean 몬스터턴(몬스터 mon)
	{
		int dmg = mon.몬스터턴(this);
	
		용사의피격(dmg);
		
		if ( 용사죽음여부() ) {
			System.out.println(getName() + " 이 쓰러졌습니다. \n<배틀종료>");
			return false;
		}
	
		return true;	
	}
	
	void 용사의피격(int dmg)
	{
		int hp = status.mHP(dmg);
	
		if( hp < 0) status.setHP(0);
		
		System.out.printf("%s 이(가) %d 의 데미지를 받았습니다.\n", getName(), dmg);
		System.out.printf("%s ( %d / %d )\n",getName(), status.getHP(), status.getMaxHP());
	}
	
	boolean 용사죽음여부()
	{
		if (status.getHP() <= 0 )	return true;
		else 						return false;
	}
		

	@Override
	public void 독상태가됨() {
		// TODO Auto-generated method stub
		System.out.println("독에 당했다!!!");
	}

	@Override
	public void 기쁨() {
		// TODO Auto-generated method stub
		System.out.println("기쁘다");
	}

	@Override
	public void 놀람() {
		// TODO Auto-generated method stub
		System.out.println("!!! 놀랐다 !!!");
	}

	@Override
	public void 황당함() {
		// TODO Auto-generated method stub
		System.out.println("??? 황당하다 ???");
	}
}