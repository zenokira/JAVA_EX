package 컬렉션;

import java.util.*;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Cat> cset = new TreeSet<Cat>();
		
		/*
		 * cset.add(new Cat(2)); cset.add(new Cat(1)); cset.add(new Cat(3));
		 * cset.add(new Cat(5)); cset.add(new Cat(4)); cset.add(new Cat(2));
		 */
		
	
		cset.add(new Cat(20));
		cset.add(new Cat(1));
		cset.add(new Cat(3));
		cset.add(new Cat(5));
		cset.add(new Cat(4));
		cset.add(new Cat(20)); 
		// 질문하기 
		// set은 중복데이터 처리 x 인데 값이 같은 경우
		// hashSet 은 다른 객체로 인식해 추가가 됐는데
		// TreeSet 은 안됨. 
		
		Iterator<Cat> iterator = cset.iterator();
		
		while (iterator.hasNext())
		{
			System.out.print(iterator.next() + " ");
		}
	}

}
/*
 * class Cat{ int size; public Cat(int s) { size = s; } public String toString()
 * { return size + ""; } }
 */

