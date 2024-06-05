package TEST;

public class 코치 {
	private String name;

	public void setName(String str) {
		this.name = str;
	}

	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
}
