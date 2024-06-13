package 용사키우기;

import java.util.HashMap;
import java.util.Iterator;

public class 소지품 {
	HashMap <String, 아이템> inven;
	
	소지품(){
		inven = new HashMap<String, 아이템>();
	}
	
	void 아이템획득(아이템 item) {
		if(hasItem(item))
		{
			int n = item.getCount();
			inven.get(item.toString()).setCount(n);
		}
		else
			inven.put(item.toString(), item);
		
		System.out.println(item.toString() + "를 획득했다");
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
			(inven.get(str)).아이템보이기();
		}
		System.out.print("-------------------------------------");
		System.out.println();
	}
}