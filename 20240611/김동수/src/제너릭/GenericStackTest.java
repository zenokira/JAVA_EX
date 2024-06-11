package 제너릭;

public class GenericStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.Push(3);
		int x = stack.Pop();
		System.out.println(x);
	}

}
