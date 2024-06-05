package TEST;

public class 선수 {
	private String name;
	private int pay;

	public void setPlayer(String str, int pay) {
		this.name = str;
		this.pay = pay;
	}

	@Override
	public String toString()
	{
		return this.name;
	}
	
	public String getName() {
		return name;
	}

	public int getPay() {
		return pay;
	}
}
