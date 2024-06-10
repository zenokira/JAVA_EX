package ex;

import java.util.Scanner;

public class ex3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pride pr = new Pride();
		pr.size();
		pr.price();
		pr.option();
		pr.discount();
		
		Sonata so = new Sonata();
		so.size();
		so.price();
		so.option();
		so.discount();
		
		Scanner sc = new Scanner(System.in);


		
		System.out.println("차량 사이즈 : ");
		String sz = sc.nextLine();
		System.out.println("차량 가격 : ");
		int p = sc.nextInt();
		sc.nextLine();
		System.out.println("차량 옵션 : ");
		int o = sc.nextInt();
		sc.nextLine();
		System.out.println("차량 할인 : ");
		int d = sc.nextInt();
		sc.nextLine();
		
		CarInfo so1 = new CarInfo(sz, p, o , d);
		so1.size();
		so1.price();
		so1.option();
		so1.discount();
		
	}

}

interface Car{
	public final static String CARSIZE1 = "small type";
	String CARSIZE2 = "middle type";
	
	public abstract void size();
	public abstract void price();
	void option();
	void discount();
}

class Pride extends CarTransfer implements Car{
	
	private int price, option, discount;
	
	public Pride(){
		price = 1600;
		option = 200;
		discount = 50;
	}
	
	@Override
	public void size()
	{
		System.out.println("자동차 크기 : " + CARSIZE1);
	}
	@Override
	public void price()
	{
		System.out.println("최고 가격 : " + price +"만원");
	}
	
	public void option()
	{
		System.out.println("풀옵션 가격 : " + option +"만원");
	}
	
	public void discount()
	{
		System.out.println("구형 교체 = "+discount+"만원 할인\n");
	}
}

class Sonata implements Car{
	
	private int price, option, discount;
	
	public Sonata(){
		price = 3000;
		option = 350;
		discount = 100;
	}
	@Override
	public void size()
	{
		System.out.println("자동차 크기 : " + CARSIZE2);
	}
	
	public void price()
	{
		System.out.println("최고 가격 : " + price +"만원");
	}
	
	public void option()
	{
		System.out.println("풀옵션 가격 : " + option +"만원");
	}
	
	public void discount()
	{
		System.out.println("구형 교체 = "+discount+"만원 할인\n");
	}
}
interface CarMaker {
	public final static String KIA = "기아자동차";
	public final static String HYUNDAI = "현대자동차";

	public abstract void maker();
}

class CarTransfer{
	public void prideCost()
	{
		System.out.println("프라이드 운송비 = 5만원");
	}
	public void sonataCost()
	{
		System.out.println("소나타 운송비 = 10만원");
	}
}

class CarInfo extends CarTransfer implements Car{
	private int price, option, discount;
	private String size;
	
	public CarInfo(String s, int p , int o , int d){
		if (s.equals("small")) 
			size = CARSIZE1;
		else 
			size = CARSIZE2;
		
		price = p;
		option = o;
		discount = d;
	}
	
	@Override
	public void size()
	{
		System.out.println("자동차 크기 : " + size);
	}
	
	public void price()
	{
		System.out.println("최고 가격 : " + price +"만원");
	}
	
	public void option()
	{
		System.out.println("풀옵션 가격 : " + option +"만원");
	}
	
	public void discount()
	{
		System.out.println("구형 교체 = "+discount+"만원 할인\n");
	}
}
