package 컬렉션;

import java.util.*;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> v = new Vector<String>();
		
		v.add("aaa");
		v.addElement("bbb");
		v.addElement("ccc");
		
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}

}
