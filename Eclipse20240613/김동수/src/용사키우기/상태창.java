package ���Ű���;

public class ����â {
	// [ ���� , maxHP, HP , maxMP, MP , EXP , ���� ]
	
	final private int beginMAX = 100;
	
	// �⺻ ���� //
	private Object job;
	private int maxHP;
	private int maxMP;
	private int HP;
	private int MP;
	private double EXP;
	private int LV;
	
	// ���ݷ� ���� //
	
	// ���� ���� //
	
	����â()
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