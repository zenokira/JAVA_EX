package 컬렉션;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap mapH = new HashMap();
		
		mapH.put(new Cat(50), "1");
		mapH.put(new Cat(30), "2");
		mapH.put(new Cat(20), "3");
		mapH.put(new Cat(60), "4");
		
		for (Object s : mapH.keySet())
			System.out.println(mapH.get(s));
	}

}
