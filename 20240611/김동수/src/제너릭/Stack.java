package 제너릭;

public class Stack<T> {
	final int size;
	T[] items;
	int top;

	public Stack() {
		this(10);
	}

	public Stack(int s) {
		size = s > 0 ? s : 10;
		items = (T[]) new Object[s];
		top = -1;
	}

	public void Push (T item) {
		if ( top == size - 1) 
			throw new FullException("스택이 꽉 차 있어 "+ item + "을 집어넣을 수 없습니다.");
		items[++top] = item;
	}
	public T Pop () {
		if ( top == - 1) 
			throw new EmptyException("스택이 비어 있어 항목을 끄집어 낼 수 없습니다.");
		return items[top--];
	}	
}
