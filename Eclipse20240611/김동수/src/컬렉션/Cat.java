package 컬렉션;

public class Cat implements Comparable{
	int size;
	public Cat(int s) {
		size = s;
	}
	public String toString()
	{
		return size + "";
	}
	@Override
	public int compareTo(Object o) {
		return size - ((Cat) o).size;
	}
	
	
	  public int hashCode() { return size % 100; }
	  
	  public boolean equals(Object ob) {
		  Cat other = (Cat) ob; return (other.size ==
	  this.size) ? true:false; }
	 
}