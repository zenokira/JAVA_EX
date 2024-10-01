package main;

public class SynchronizedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintThread T1 = new PrintThread("스레드 A");
		PrintThread T2 = new PrintThread("스레드 B");
		
		T1.start();
		T2.start();
		
		try {
			T1.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

class PrintThread extends Thread{
	private String threadName;
	
	PrintThread( String name)
	{
		threadName = name;
	}
	
	public void run()
	{
		printCount();
		System.out.println("스레드 " + threadName + "종료");
	}
	
	public void printCount()
	{
		try {
			for(int i = 10; i > 0; i--)
			{
				System.out.println(threadName + " : Counter --- " + i);
			}
		}
		catch(Exception e)
		{
			System.out.println(threadName + " : 인터럽트");
		}
	}
}