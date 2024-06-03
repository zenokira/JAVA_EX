package 김동수;

import java.util.Arrays;

public class BinarySearchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = new int[] {3,2,1,4,5};
		
		Arrays.sort(a);
		
		int i = Arrays.binarySearch(a, 3);
		System.out.println(i);
		
		i = Arrays.binarySearch(a, 0);
		System.out.println(i);
		
		i = Arrays.binarySearch(a, 6);
		System.out.println(i);
		
	}

}
