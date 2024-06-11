package 컬렉션;

import java.util.*;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack st = new Stack();
		
		st.push("사랑");
		String e = (String) st.peek();
		if(st.empty()) System.out.println(e + "가 peek 된 후 스택이 비었습니다.");
		e = (String) st.pop();
		if(st.empty()) System.out.println(e + "가 pop 된 후 스택이 비었습니다.");
		
		st.push("온유");
		st.push("충성");
		System.out.println(st.search("충성"));
		System.out.println(st.search("온유"));
	}

}
