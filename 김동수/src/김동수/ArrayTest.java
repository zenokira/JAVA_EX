package 김동수;

import java.util.Arrays;

public class ArrayTest {
	public static void main(String [] args) {
		int[] array = { 1,5,3,2,4};
		
		for( int e : array) {
			System.out.print(e + "");
		}
		System.out.println();
		
		Arrays.sort(array);
		
		for( int e : array) {
			System.out.print(e + "");
		}
	}
}
