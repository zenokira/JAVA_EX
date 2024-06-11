package 컬렉션;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class UserExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList <String> stack = new LinkedList<String>();
		
		stack.push("aaa");
		stack.push("bbb");
		
		System.out.println("Stack : " + stack );
		String s = stack.pop();
		System.out.println(s + "가(이) 팝업됨");
		System.out.println("Stack : " + stack);
		
		LinkedList <String> queue = new LinkedList<String>();
		queue.offer("ccc");
		queue.offer("ddd");
		System.out.println("Queue : " + queue);
		String ss = queue.poll();
		System.out.println(ss+ "가(이) 반환 및 제거됨");
		System.out.println("Queue : " + queue);
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("eee");
		list.add("fff");
		list.add(0,"ggg");
		list.add(0,"ttt");
		System.out.println("List : " + list);
		
		String sss = list.remove(1);
		System.out.println(sss + " 가(이) 제거됨");
		String t = list.get(1);
		System.out.println("인덱스 1 위치의 값은 " + t);
		System.out.println("List : " + list);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * Vector<Double> v = new Vector<Double>(); v.add(4.5); v.add(3.4); v.add(2.9);
		 * 
		 * Iterator<Double> it = v.iterator();
		 * 
		 * double sum = 0.0, d;
		 * 
		 * while ( it.hasNext()) { d = it.next(); sum += d; } System.out.println(sum);
		 */
	}

}