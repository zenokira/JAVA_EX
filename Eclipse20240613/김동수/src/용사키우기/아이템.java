package ���Ű���;

public class ������ {
	private String name;
	private int id;
	private int count;
		
	public ������()
	{
		
	}
	public ������(String n, int id, int count)
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
	
	public void �����ۺ��̱�() {
		System.out.println("\n������ �̸� : " + name + "\t�������� : " + count );
	}

	
	@Override
	public String toString()
	{
		return this.name;
	}

}