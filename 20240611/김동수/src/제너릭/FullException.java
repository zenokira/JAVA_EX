package 제너릭;

public class FullException extends RuntimeException{
	public FullException() {
		this("스택 꽉 참");
	}
	public FullException(String exception) {
		super(exception);
	}

}

