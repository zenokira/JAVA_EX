package 용사키우기;

import java.util.HashMap;

public class 소지품 {
	HashMap <String, 아이템> inven;
	
	소지품(){
		inven = new HashMap<String, 아이템>();
	}
	
	void 아이템습득(아이템 item) {
		if(hasItem(item))
		{
			int n = inven.get(item.toString()).getCount();
			inven.get(item.toString()).setCount(n);
		}
		else
			inven.put(item.toString(), item);
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
}
