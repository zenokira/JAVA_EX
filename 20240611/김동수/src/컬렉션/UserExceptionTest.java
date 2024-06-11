package 컬렉션;

import java.util.Iterator;
import java.util.Vector;

public class UserExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Vector<Double> v = new Vector<Double>();
			v.add(4.5);
			v.add(3.4);
			v.add(2.9);
			
			Iterator<Double> it = v.iterator();
			
			double sum = 0.0, d;
			
			while ( it.hasNext())
			{
				d = it.next();
				sum += d;
			}
			System.out.println(sum);
	}

}
