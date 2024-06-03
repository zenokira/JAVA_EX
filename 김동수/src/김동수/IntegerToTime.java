package 김동수;

import java.util.Scanner;

public class IntegerToTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("숫자 입력 >> ");
		Scanner sc  = new Scanner ( System.in);
		
		int i = sc.nextInt();
		sc.close();
		
		int hour = i / 3600;
		int remain = i % 3600;
		int minute = remain / 60;
		int second = remain % 60;
		
		System.out.println(hour + " " + minute + " " + second + " ");
	}

}
