package 문제;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * int x = sc.nextInt(); if (x > 10 && x < 20) System.out.println("[1-1]1");
		 * 
		 * String A = sc.next(); char ch = A.charAt(0); if (ch != ' ' && ch != '\t')
		 * System.out.println("[1-1]2"); if (ch == 'x' || ch == 'X')
		 * System.out.println("[1-1]3");
		 * 
		 * if (ch >= '0' && ch <= '9') System.out.println("[1-1]4"); if ((ch >= 'A' &&
		 * ch <= 'Z') || (ch >= 'a' && ch <= 'z')) System.out.println("[1-1]5");
		 * 
		 * int year = sc.nextInt(); if (year % 400 == 0 || (year % 4 == 0 && year % 100
		 * != 0)) System.out.println("[1-1]6");
		 * 
		 * boolean powerOn = sc.nextBoolean(); if (!powerOn)
		 * System.out.println("[1-1]7");
		 * 
		 * String str = new String(); str = sc.next();
		 * 
		 * if (str.equals("yes")) System.out.println("[1-1]7"); sc.close();
		 */
		int total = 0;

		for (int i = 1; i <= 20; i++) {
			if (i % 2 != 0 && i % 3 != 0) {
				total += i;
				System.out.println(i);
			}
		}
		System.out.println("[1-2] " + total);

		total = 0;
		int sum = 0;
		for ( int i = 1; i <= 10; i++)
		{
			sum += i;
			total += sum;
		}
		System.out.println("[1-3] " + total);//
		
		total = 0; 
		int i,j=1;
		for ( i = 1; ;i++)
		{
			total += i*j;
			if(total >= 100) break;
			j=-j;
		}
		System.out.println("[1-4] " + i);
			
		
		for ( int x = 1; x <= 6 - x; x++)//6-i
		{
			System.out.print( x );
			System.out.print(" + ");
			System.out.print(6 - x);
			System.out.println(" = 6 ");
		}
		System.out.println("[1-5] ");
	
		
		
		int y = 0;
		while ( y < 10)
		{
			int x = 0;
			while ( x <= y )
			{
				System.out.print("*");
				x++;
			}
			System.out.println();
			y++;
		}
		System.out.println("[1-6]");
	
		String str = "41389";
		int s = 0;
		for (int i1 = 0; i1 < str.length(); i1++)
		{
			s += str.charAt(i1) - '0';
		}
		System.out.println("[1-7] " + s);
	
	
	}
	

}
