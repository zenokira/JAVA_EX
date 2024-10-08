package main;

import java.util.Vector;

public class InterruptingThreadTest extends Thread {
//	static Vector<InterruptingThreadTest> th = new Vector<InterruptingThreadTest>();

	public InterruptingThreadTest(String s) {super.setName(s);}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread producer = new Producer();
		Thread consumer = new Consumer();
		
		producer.setPriority(Thread.MIN_PRIORITY);
		consumer.setPriority(Thread.MAX_PRIORITY);
		
		producer.start();
		consumer.start();
		
		
		
		
		/*
		 * for(int i = 0; i < 30; i++) { String s = String.format("%d", i); th.add( new
		 * InterruptingThreadTest(s)); }
		 * 
		 * for(InterruptingThreadTest t : th) { t.start(); }
		 * th.elementAt(0).interrupt();
		 * 
		 * if(th.elementAt(0).isInterrupted())System.out.println("플래그");
		 */
	}

	public void run() {

		for(int i = 1; i <= 2; i++)
		{
			if(Thread.interrupted()) {
				System.out.println(Thread.currentThread().getName() + " code");
			}
			else {
				System.out.println(Thread.currentThread().getName() + " normal");
			}
		}
		
		/*
		 * try { Thread.sleep(1000); System.out.println("잠든 상태에서 벗어남"); } catch
		 * (InterruptedException e) { System.out.println("인터럽트 발생 : " + e); }
		 */
	}
}

class Producer extends Thread{
	public void run() {
		for(int i = 0; i < 5; i++)
		{
			System.out.println("Producer : " + i);
			Thread.yield();
		}
		
	}
}

class Consumer extends Thread{
	public void run() {
		for(int i = 0; i < 5; i++)
		{
			System.out.println("Consumer : " + i);
			Thread.yield();
		}
		
	}
}