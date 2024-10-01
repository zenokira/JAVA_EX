package main;

import java.util.Scanner;

public class Example implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Example(), "쓰레드 A");
		Thread t2 = new Thread(new Example(), "쓰레드 B");
		Thread t3 = new Thread(new Example(), "쓰레드 C");
		
		t1.start();
		System.out.println(t1.currentThread().getName());
		t1.join();
		System.out.println(t1.currentThread().getName());
		t2.start();
		t2.join();
		t3.start();
	}
	
	public void run()
	{
		System.out.println("정수 입력을 기다리고 있습니다. 입력바랍니다. >> ");
		Scanner s = new Scanner(System.in);
		
		int val = s.nextInt();
		
		System.out.println("자식 스레드 종료합니다.");
	}
}

class ThreadT implements Runnable
{
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
		
	}
}
