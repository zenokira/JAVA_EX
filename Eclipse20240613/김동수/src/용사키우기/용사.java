package ���Ű���;

public class ��� extends ��� implements �����̻�, ����ǥ��{

	���(){
		
	}
	
	���(String name){
		this.name = name;
		Initialize();
	}
	
	public void Initialize()
	{
		status = new ����â();
		inventory = new ����ǰ();
	}

	public void setItem(������ item)
	{
		inventory.������ȹ��(item);
	}
	
	public void showInvetory()
	{
		inventory.showItem();
	}
	
	@Override
	public void �����°���() {
		// TODO Auto-generated method stub
		System.out.println("���� ���ߴ�!!!");
	}

	@Override
	public void ���() {
		// TODO Auto-generated method stub
		System.out.println("��ڴ�");
	}

	@Override
	public void ���() {
		// TODO Auto-generated method stub
		System.out.println("!!! ����� !!!");
	}

	@Override
	public void Ȳ����() {
		// TODO Auto-generated method stub
		System.out.println("??? Ȳ���ϴ� ???");
	}
}