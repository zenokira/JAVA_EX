package ex;

public class ex2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flower flower = new Flower();
		Rose rose = new Rose();
		Tulip tulip = new Tulip();
		
		flower.printAttributes();
		rose.printAttributes();
		tulip.printAttributes();
		
	}

}

class Flower
{
	public String Flowername;
	public int cost;
	
	public Flower()
	{
		Flowername = "꽃";
		cost = 10000;
	}
	
	public Flower(String fn, int cost)
	{
		Flowername = fn;
		this.cost = cost;
	}
	
	protected void printAttributes()
	{
		System.out.println("Flowername=" + Flowername + "\tcost=" + cost);
	}
}

class Rose extends Flower{
	
	public Rose() {
		super("장미", 20000);
	}
}
class Tulip extends Flower{
	
	public Tulip() {
		super("튤립", 30000);
	}
}
