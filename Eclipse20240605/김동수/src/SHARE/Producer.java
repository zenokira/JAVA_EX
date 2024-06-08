package SHARE;

import java.util.Random;

public class Producer {
	private Random generator = new Random();
	
	public void produce() {
		int loop = generator.nextInt(4) + 2;
		int res , val;
		
		for ( int i = 0; i < loop; i++)
		{
			val = generator.nextInt(101);
			res = SharedData.setVal(val);
			if ( res < 0 ) System.out.println("write : 버퍼가 꽉 차 데이터를 추가할 수 없습니다.");
			else System.out.println("write : " + val);
		}
	}
}
