package main;

public class 몬스터 extends 스탯 implements 상태이상 {
	private String name;
	private String [] strMonsterlist = { "토끼", "여우", "슬라임", "고블린", "오크", "마왕" };
	private final int MonsterIdx = 6;

	몬스터() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void 랜덤몬스터생성() {

		int rT = 몬스터종류생성(getMonsterIdx());
		int rLV = 몬스터LV생성(rT + 1);
		int rHP = 몬스터HP생성(rLV);
		int rMP = 몬스터MP생성(rLV);

		setName(getStrMonsterlist()[rT]);
		setLV(rLV);
		initHP(rHP);
		initMP(rMP);
		
		set몬스터공격력(rLV);
		set몬스터방어력(rLV);
	}
	
	public void 몬스터공격력계산()
	{
		
	}
	
	public String[] getStrMonsterlist() {
		return strMonsterlist;
	}

	public void set몬스터공격력(int n)
	{
		int ad = 시스템.getRandInt(n) + n;
		set물리공격력(ad);
		int ap = 시스템.getRandInt(n) + n;
		set마법공격력(ap);
	}
	
	public void set몬스터방어력(int n)
	{
		int ac = 시스템.getRandInt(n) + n;
		set물리방어력(ac);
		int mr = 시스템.getRandInt(n) + n;
		set마법공격력(mr);
	}

	public int getMonsterIdx() {
		return MonsterIdx;
	}

	int 몬스터종류생성(int n) {
		return 시스템.getRandInt(n);
	}

	int 몬스터LV생성(int n) {
		return 시스템.getRandInt(n) + n;
	}

	int 몬스터HP생성(int n) {
		return 시스템.getRandInt(n) * 10 + n * 30;
	}

	int 몬스터MP생성(int n) {
		return 시스템.getRandInt(n) * 10 + n * 30 - 15;
	}
	
	public int 몬스터턴(용사 hero)
	{
		int choice = 1;
		int dmg = 0;
		switch (choice) {
		case 1:		
			dmg = 몬스터의공격(hero);
			return dmg;
		}
		return 0;
	}
	
	int 몬스터의공격(용사 hero)
	{
		int dmg = 물리데미지계산(hero.get스탯().get물리방어력());
		return dmg;
	}
	
	boolean 몬스터죽음여부()
	{
		if (getHP() == 0 )	return true;
		else				return false;
	}
	
	public void 몬스터의피격(int dmg)
	{
		int hp = mHP(dmg);
		
		if( hp < 0) setHP(0);
				
		System.out.printf("%s 에게 %d 의 데미지를 가하였습니다.\n", getName(), dmg);
		System.out.printf("%s ( %d / %d )\n",getName(), getHP(), getMaxHP());
	}
	

	@Override
	public void 독상태가됨() {
		System.out.println();
	}

	@Override
	public void 상태창보기() {
		System.out.println();
		System.out.printf("%s(%d)\t", getName(), getLV());
		System.out.println("HP : " + getHP() + " / " + getMaxHP());
	}

}
