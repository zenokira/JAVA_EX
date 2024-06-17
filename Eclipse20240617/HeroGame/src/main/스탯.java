package main;

public class 스탯 {
	// [ 직업 , maxHP, HP , maxMP, MP , EXP , 레벨 ]
	//enum
	final private int beginMAX = 100;
	
	// 기본 스탯 //
	protected Object job;
	protected int maxHP;
	protected int maxMP;
	protected int HP;
	protected int MP;
	protected double EXP;
	protected int LV;
	
	// 공격력 스탯 //
	protected int 물리공격력;
	protected int 마법공격력;
		
	// 방어력 스탯 //
	protected int 물리방어력;
	protected int 마법방어력;
	
	스탯()
	{
		Initialize();
	}
	
	스탯(int LV, int maxHp, int maxMp ){
		initHP(maxHP);
		initMP(maxMP);
		this.LV = LV;	
	}
	
	void Initialize() {
		job = new Object();
		initHP(beginMAX);
		initMP(beginMAX);
		EXP = 0;
		LV = 1;
		물리공격력 = 마법공격력 = 10;
		물리방어력 = 마법방어력 = 5;
	}
	
	public void 상태창보기()
	{
		System.out.println();
		System.out.println("---------------<상태창>---------------");
		System.out.print("LV : " + getLV() + "\t");
		System.out.println("EXP : " + getEXP() + "%");
		System.out.println("직업 : ");
		System.out.println("HP : " + getHP() + " / "+ getMaxHP());
		System.out.println("MP : " + getMP() + " / "+ getMaxMP());
		System.out.println("------------------------------------");
		System.out.println("물리공격력 : " + get물리공격력() + "\t마법공격력 : " + get마법공격력());
		System.out.println("물리방어력 : " + get물리방어력() + "\t마법방어력 : " + get마법방어력());
		System.out.println("------------------------------------");
	}

	public void initHP(int hp)
	{
		setHP(hp); setMaxHP(hp);
	}
	public void initMP(int mp)
	{
		setMP(mp); setMaxMP(mp);
	}

	public int mHP(int Hp) {
		HP -= Hp;
		return HP;
	}
	public int mMP(int Mp) {
		MP -= Mp;
		return MP;
	}

	
	
	// getter setter
	public Object getJob() {
		return job;
	}

	public void setJob(Object job) {
		this.job = job;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getMaxMP() {
		return maxMP;
	}

	public void setMaxMP(int maxMP) {
		this.maxMP = maxMP;
	}

	public int getHP() {
		return HP;
	}
	public int getMP() {
		return MP;
	}
	public void setHP(int hp) {
		this.HP = hp;
	}
	public void setMP(int mp) {
		this.MP = mp;
	}
	
	public double getEXP() {
		return EXP;
	}

	public void setEXP(double eXP) {
		EXP = eXP;
	}

	public int getLV() {
		return LV;
	}

	public void setLV(int lV) {
		LV = lV;
	}
	
	public void LVUP() {
		LV += 1;
	}
	
	public void changeEXP(double exp) {
		EXP += exp;
	}

	public int getBeginMAX() {
		return beginMAX;
	}
	public int get물리공격력() {
		return 물리공격력;
	}
	public void set물리공격력(int 물리공격력) {
		this.물리공격력 = 물리공격력;
	}
	public int get마법공격력() {
		return 마법공격력;
	}
	public void set마법공격력(int 마법공격력) {
		this.마법공격력 = 마법공격력;
	}
	public int get물리방어력() {
		return 물리방어력;
	}
	public void set물리방어력(int 물리방어력) {
		this.물리방어력 = 물리방어력;
	}
	public int get마법방어력() {
		return 마법방어력;
	}
	public void set마법방어력(int 마법방어력) {
		this.마법방어력 = 마법방어력;
	}
	
	
	public int 물리데미지계산(int ac)
	{
		int dmg = (this.물리공격력 - ac);
		if( dmg <= 0) dmg = 0;
		
		return dmg;
	}
	public int 마법데미지계산(int mr)
	{
		int dmg = this.마법공격력 - mr;
		if( dmg <= 0) dmg = 0;
		
		return dmg;
	}
	
	double 경험치계산(몬스터 mon)
	{
		double exp = 0;
		if ( getLV() >= mon.getLV()) exp = 50;	//exp = (double)(getLV() - mon.getLV()) * 2.5; 
		else						 exp = 50;	//exp = (double)(mon.getLV() - getLV()) * 4.5;
		return exp;
	}
	
	public void 레벨업여부(몬스터 mon)
	{
		double exp = 경험치계산(mon);
		System.out.println("경험치가 " + exp + " 올랐습니다.");
		if ( this.getEXP() + exp >= 100 ) {
			레벨업(exp);
		}
		else
		{
			changeEXP(exp);
			System.out.println("LV : " + getLV() + " / (EXP : " + getEXP() + "%)");
		}	
	}
	
	void 레벨업(double exp)
	{
		
		int n = 4;
		LVUP();
		
		System.out.println("레벨이 올랐습니다. ");
		
		changeEXP( exp - 100);
		
		initHP(getMaxHP() + n);
		initMP(getMaxMP() + n);
		
		 
		set물리공격력(get물리공격력() + 1 );
		set마법공격력(get마법공격력() + 1 );
		set물리방어력(get물리방어력() + 1 );
		set마법방어력(get마법방어력() + 1 );
		
		상태창보기();
	}
}