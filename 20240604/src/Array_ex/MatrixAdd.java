package Array_ex;

import java.util.Random;

public class MatrixAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] m1 = new int[3][3], m2 = new int[3][3], m3 = new int[3][3];
		Random rnd = new Random();
		
		for ( int i = 0; i < m1.length; i++)
		{
			for ( int j = 0; j < m1[i].length; j++)
			{
				m1[i][j] = rnd.nextInt(100);
				m2[i][j] = rnd.nextInt(100);
			}
		}
		
		Plus(m1,m2,m3);
		
		Print(m1);
		Print(m2);
		
		System.out.println("======================");
		
		Print(m3);
		
	}
	
	public static void Plus(int[][] arr1, int[][] arr2, int[][] arr3)
	{
		for ( int i = 0; i < arr1.length; i++)
		{
			for ( int j = 0; j < arr1[i].length; j++)
			{
				arr3[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
	}
	
	public static void Print(int[][] arr)
	{
		for ( int i = 0; i < arr.length; i++)
		{
			for ( int j = 0; j < arr[i].length; j++)
			{
				System.out.println( arr[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}

}
