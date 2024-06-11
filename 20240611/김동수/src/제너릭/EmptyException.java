package 제너릭;

public class EmptyException extends RuntimeException{
	public EmptyException() {
		this("스택 빔");
	}
	public EmptyException(String exception) {
		super(exception);
	}
}
