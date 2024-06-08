package SHARE;

public class SharedDataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer c = new Consumer();
		Producer p = new Producer();
		
		for (int i = 0; i < 3; i++)
		{
			p.produce();
			c.consume();
		}
	}

}
