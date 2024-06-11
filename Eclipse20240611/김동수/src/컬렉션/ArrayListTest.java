package 컬렉션;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		
		// 출력 방법 1. list 객체 자체를 출력
		// 출력 방법 2. index 사용해서 해당 위치 데이터 출력
		// 출력 방법 3. foreach 사용
		// 출력 방법 4. iterator 사용
		// 출력 방법 5. 데이터를 배열화 하여 해당 배열 객체 출력
		
		
		list.add("aaa");
		list.add("bbb");
		list.add(2,"ccc");
		list.add("ddd");
		
		System.out.println("구성데이터 : " + list);//4
		
		int pos = list.indexOf("bbb");
		System.out.println("bbb의 위치 : " + pos);
		
		boolean check1 = list.isEmpty();
		boolean check2 = list.contains("ddd");
		System.out.println("비어 있음 : " + check1 + " 포함 여부 : "+ check2);
		
		int size = list.size();
		System.out.println("리스트의 크기 "+size);
		
		String item = list.get(0);
		System.out.println("0번째 위치 데이터 : " + item);
		
		System.out.println("데이터 반복처리 - 첫번째방법");
		for ( int i = 0; i < list.size(); i++)
			System.out.println("Index" + i + " - item : " +list.get(i));
		
		System.out.println("데이터 반복처리 - 두번째방법");
		for ( String str : list)
			System.out.println("item is : " + str);
		
		System.out.println("데이터 반복처리 - 세번째방법");
		for (Iterator<String> it = list.iterator(); it.hasNext();)
			System.out.println("데이터 : " + it.next());
		
		
		list.set(1, "eee");
		System.out.println("수정 후 리스트 : " + list);
		
		list.remove(0);
		list.remove("ccc");
		System.out.println("리스트의 최종 내용 : " + list);
		
		String [] simpleArray = list.toArray(new String[list.size()]);
		System.out.println("변환 배열 : " + Arrays.toString(simpleArray));//5
	
		String [] sA = list.toArray(new String [list.size()]);
		System.out.println(Arrays.toString(sA));
		
		
		// 마지막 2줄 물어보기
	}

}
