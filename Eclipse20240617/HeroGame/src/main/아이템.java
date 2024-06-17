package main;

public class 아이템 {
	private String name;
	private int count;
		
	public 아이템()
	{
		
	}
	public 아이템(String n, int count)
	{
		name = n;
		this.count = count;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String str) {
		this.name = str;
	}
	
	public int getCount() {
		return this.count;
	}
	public void setCount(int c) {
		this.count = c;
	}
	
	public void 아이템수량변경(int c)
	{
		this.count += c;
	}
	
	public void 아이템정보보이기() {
		System.out.println("\n아이템 이름 : " + name + "\t\t보유수량 : " + count );
	}

	
	@Override
	public String toString()
	{
		return this.name;
	}

}