package ���Ű���;

import java.util.HashMap;
import java.util.Iterator;

public class ����ǰ {
	HashMap <String, ������> inven;
	
	����ǰ(){
		inven = new HashMap<String, ������>();
	}
	
	void ������ȹ��(������ item) {
		if(hasItem(item))
		{
			int n = item.getCount();
			inven.get(item.toString()).setCount(n);
		}
		else
			inven.put(item.toString(), item);
		
		System.out.println(item.toString() + "�� ȹ���ߴ�");
	}
	
	boolean hasItem(������ item)
	{
		if (inven.containsKey(item.toString()))
		{
			return true;
		}
		else 
			return false;
	}
	
	void showItem ()
	{
		System.out.println();
		System.out.print("---------------<������>---------------");
		for (String str : inven.keySet() )
		{
			(inven.get(str)).�����ۺ��̱�();
		}
		System.out.print("-------------------------------------");
		System.out.println();
	}
}