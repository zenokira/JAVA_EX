package main;

import java.util.HashMap;


public class 소지품 {
	private HashMap <String, 아이템> inven;
	
	소지품(){
		inven = new HashMap<String, 아이템>();
	}
	
	void 아이템획득(아이템 item) {
		if(hasItem(item))
		{
			int n = item.getCount();
			inven.get(item.toString()).아이템수량변경(n);
		}
		else
			inven.put(item.getName(), item);
		
		System.out.println(item.getName() + "를 획득했다");
	}
	
	boolean hasItem(아이템 item)
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
		System.out.print("---------------<보유중>---------------");
		for (String str : inven.keySet() )
		{
			(inven.get(str)).아이템정보보이기();
		}
		System.out.print("-------------------------------------");
		System.out.println();
	}
}