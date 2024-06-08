package SHARE;

import java.util.Random;

public class Consumer {
	private Random generator = new Random();
	
	public void consume() {
		int loop = generator.nextInt(4) + 2;
		int res;
		
		for ( int i = 0; i < loop ; i++)
		{
			res = SharedData.getVal();
			if ( res < 0 ) System.out.println("read : 데이터가 없습니다.");
			else System.out.println("read : " + res);
		}
	}
}
