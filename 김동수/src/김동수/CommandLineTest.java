package 김동수;

public class CommandLineTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] t = new int[] { 1, 2};

		/*
		 * ModifyArray(t);
		 * 
		 * 
		 * for ( int j = 0; j < t.length; j++) { System.out.println(t[j] + " ");
		 * System.out.println(); }
		 */
		  
		 System.out.println(t);
		 
		 swap(t, 0 ,1);
		 System.out.println(t);
		 

	}

	static void ModifyArray(int[] b) {
		for (int j = 0; j < b.length; j++)
			b[j] *= 2;
	}

	public static void swap(final int[] arr, final int pos1, final int pos2) {
		final int temp = arr[pos1];

		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	public void print(int[] array)
	{
		
	}

}
