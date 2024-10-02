package main;

public class WaitNotify {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ThreadB nt = new ThreadB();
		nt.start();
		Thread.sleep(100);
		synchronized(nt)
		{
			try {
				System.out.println("대기중");
				while(!nt.active) nt.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println( " : " + nt.total);
		}
	}

}

class ThreadB extends Thread{
	public boolean active =false;
	int total;
	@Override
	public void run() {
		synchronized(this) {
			for(int i = 0; i < 100; i++)
			{
				total += i;
			}
			active = true;
			notify();
		}
	}
}