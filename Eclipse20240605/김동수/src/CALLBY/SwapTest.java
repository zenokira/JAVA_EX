package CALLBY;

public class SwapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int[] { 5, 3 };
		
		swap(arr , 0 , 1);
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
	
	public static void swap(int[] arr, int idx1, int idx2)
	{
		int tmp;
		
		tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

}
