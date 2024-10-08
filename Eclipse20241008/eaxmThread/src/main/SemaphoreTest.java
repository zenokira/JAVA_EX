package main;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int numOfThreads = 10;
		final int numOfpermits = 2;
		
		Semaphore semaphore = new Semaphore(numOfpermits, true);
		semaThreadB threads[] = new semaThreadB[numOfThreads];
		
		for(int i = 0; i < numOfThreads; i++)
		{
			threads[i] = new semaThreadB(semaphore, "Thread " + i);
			threads[i].start();
		}
	}

}

class semaThreadB extends Thread
{
	String threadName;
	Semaphore semaphore;
	
	public semaThreadB(Semaphore sema, String name) {
		this.semaphore = sema;
		this.threadName = name;
	}
	
	public void run()
	{
		try {
			semaphore.acquire();
			System.out.println(threadName + " 획득 ");
			System.out.println(threadName + " 작업중 ");
			Thread.sleep(3000);
			System.out.println(threadName + " 작업종료 ");
			System.out.println(threadName + " 양도 ");
			semaphore.release();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}