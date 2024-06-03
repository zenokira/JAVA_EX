package 김동수;

public class ShiftOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 128, y = -128;
		
		System.out.println(" x >> 2 : " + Integer.toBinaryString(x) + " -> " + Integer.toBinaryString( x >> 2));
		System.out.println(" y >> 2 : " + Integer.toBinaryString(y) + " -> " + Integer.toBinaryString( y >> 2));

		System.out.println(" x >>> 2 : " + Integer.toBinaryString(x) + " -> " + Integer.toBinaryString( x >>> 2));
		System.out.println(" y >>> 2 : " + Integer.toBinaryString(y) + " -> " + Integer.toBinaryString( y >>> 2));

		System.out.println(" x << 2 : " + Integer.toBinaryString(x) + " -> " + Integer.toBinaryString( x << 2));
		System.out.println(" y << 2 : " + Integer.toBinaryString(y) + " -> " + Integer.toBinaryString( y << 2));
		

	}

}
