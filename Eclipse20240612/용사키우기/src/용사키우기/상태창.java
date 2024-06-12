package 용사키우기;

public class 상태창 {
	// [ 직업 , maxHP, HP , maxMP, MP , EXP , 레벨 ]
	
	final private int beginMAX = 100;
	
	// 기본 스탯 //
	private Object job;
	private int maxHP;
	private int maxMP;
	private int HP;
	private int MP;
	private double EXP;
	private int LV;
	
	// 공격력 스탯 //
	
	// 방어력 스탯 //
	
	상태창()
	{
		Initialize();
	}

	void Initialize() {
		job = new Object();
		maxHP = maxMP = HP = MP = beginMAX;
		EXP = 0;
		LV = 1;
	}
	
}
