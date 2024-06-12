package 용사키우기;

public class 아이템 {
	private String name;
	private int id;
	private int count;
		
	public 아이템()
	{
		
	}
	public 아이템(String n, int id, int count)
	{
		name = n;
		this.id = id;
		this.count = count;
	}
	
	public int getCount() {
		return this.count;
	}
	public void setCount(int c) {
		this.count += c;
	}
	
	public void 아이템보이기() {
		
	}

	
	@Override
	public String toString()
	{
		return this.name;
	}

}
