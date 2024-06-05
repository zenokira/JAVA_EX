package MyMathTest;

import java.util.Scanner;

public class MyMathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("반지름을 입력하세요");
		
		Scanner sc = new Scanner(System.in);
		
		double r = sc.nextDouble();
		System.out.println("원의 둘레 : " + MyMath.getCirclePerimeter(r));
		System.out.println("원의 면적 : " + MyMath.getCircleArea(r));
		
		System.out.println("마일을 입력하세요 : " );
		double m = sc.nextDouble();
		System.out.println(MyMath.mileToKilometer(m)+ "킬로미터에 해당합니다.");
		
		System.out.println("킬로미터를 입력하세요 : " );
		double km = sc.nextDouble();
		System.out.println(MyMath.kilometerToMile(km)+ "마일에 해당합니다.");
	}

}
