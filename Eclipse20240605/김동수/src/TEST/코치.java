package TEST;

public class 코치 {
	private String name;

	public void setName(String str) {
		this.name = str;
	}

	public String getName() {
		return this.name;
	}
	
	public void delete()
	{
		System.out.println("> " + name + "가 삭제되었습니다.");
		this.name = null;
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
	

}
