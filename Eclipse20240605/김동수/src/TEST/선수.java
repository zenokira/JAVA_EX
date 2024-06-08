package TEST;

public class 선수 {
	private String name;
	private int pay;

	public void setPlayer(String str, int pay) {
		this.name = str;
		this.pay = pay;
	}
	
	public void delete()
	{
		System.out.println("> " + name + "가 삭제되었습니다.");
		this.name = null;
		this.pay = 0;
	}
	
	public void delete(String str)
	{
		this.name = str;
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
