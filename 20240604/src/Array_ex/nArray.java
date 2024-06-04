package Array_ex;

public class nArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] array = {{62,17,42,64}, {18,96,29,5},{6,3,6,5}};
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.println();
			for(int j = 0; j < array[i].length;j++)
			{
				System.out.println(array[i][j] + " ");
			}
		}
		System.out.println();
	}

}
