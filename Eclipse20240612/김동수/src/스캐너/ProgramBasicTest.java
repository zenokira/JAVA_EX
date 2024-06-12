package 스캐너;

import java.util.Scanner;

public class ProgramBasicTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Scanner sc = new Scanner (System.in);
			System.out.println(">> ");
			
			while( sc.hasNextInt())
			{
				int i = sc.nextInt();
				System.out.println("입력 값 : "+i);
				System.out.print(">> ");
			}
			System.out.println("입력이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
