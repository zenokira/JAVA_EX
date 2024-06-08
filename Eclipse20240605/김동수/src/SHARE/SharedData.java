package SHARE;

public class SharedData {
	private static int count = 0;
	public final static int MaxSize = 100;
	private static int[] buffer = new int[MaxSize];
	
	public static int getVal()
	{
		if ( count != 0) return buffer[--count];
		else return -1;
	}
	
	public static int setVal(int s ) {
		if ( count != MaxSize) {
			buffer[count++] = s;
			return count;
		}
		else return -1;
	}
}
