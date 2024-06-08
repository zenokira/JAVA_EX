package CONSTRUCTOR;

public class ConstructorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat c = new Cat("이쁜이", 45);
		System.out.println(c.toString() + "의 몸무게는 " + c.getSize());
	}

}

class Cat {
	int size;
	String name;
	
	public Cat(String n , int s) {
		name = n;
		size = s;
	}
	
	/*
	 * @Override public String toString() { return this.name; }
	 */
	
	public int getSize() { return size; }
	public String toString() { return name; }
	
}
