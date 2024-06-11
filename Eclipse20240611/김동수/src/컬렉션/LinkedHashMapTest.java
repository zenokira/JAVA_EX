package 컬렉션;

import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedHashMap lhmap = new LinkedHashMap<Cat,String>();
		
		lhmap.put(new Cat(50), "Fat");
		lhmap.put(new Cat(30), "Normal");
		lhmap.put(new Cat(20), "Slim");
		lhmap.put(new Cat(60), "Big");
		
		Set<Cat> ks = lhmap.keySet();
		
		for(Cat key : ks) {
			System.out.println(key + " ==> " + lhmap.get(key));
		}
	}

}
