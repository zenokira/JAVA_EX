package 용사키우기;

public class 용사 extends 사람 implements 상태이상, 감정표현{

	용사(){
		
	}
	
	용사(String name){
		this.name = name;
		Initialize();
	}
	
	public void Initialize()
	{
		status = new 상태창();
		inventory = new 소지품();
	}

	public void setItem(아이템 item)
	{
		inventory.아이템습득(item);
	}
	@Override
	public void 독상태가됨() {
		// TODO Auto-generated method stub
		System.out.println("독에 당했다!!!");
	}

	@Override
	public void 기쁨() {
		// TODO Auto-generated method stub
		System.out.println("기쁘다");
	}

	@Override
	public void 놀람() {
		// TODO Auto-generated method stub
		System.out.println("!!! 놀랐다 !!!");
	}

	@Override
	public void 황당함() {
		// TODO Auto-generated method stub
		System.out.println("??? 황당하다 ???");
	}
}
