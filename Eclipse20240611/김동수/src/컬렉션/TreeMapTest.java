package 컬렉션;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Cat, String> trmap = new TreeMap<Cat, String>();
		
		trmap.put(new Cat(50),"Fat");
		trmap.put(new Cat(30),"Normal");
		trmap.put(new Cat(20),"Slim");
		trmap.put(new Cat(60),"Big");
		
		Set<Cat> ks = trmap.keySet();
		
		for(Cat key : ks) {
			System.out.println(key + " ==> " + trmap.get(key));
		}
	}

}
