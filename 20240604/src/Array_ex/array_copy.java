package Array_ex;

public class array_copy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray1 = new int[] {1,2,3};
		int[] myArray2 = myArray1.clone();
		
		myArray2[1] = 0;

		for (int i : myArray2)
		{
			System.out.println(i);
		}
	}

}
