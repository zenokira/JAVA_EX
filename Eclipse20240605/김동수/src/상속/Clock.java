package 상속;

import java.util.*;

class Clock {
	public String getLocation() {return "한국";}
	
	int getHours()
	{
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	
	int getMinutes() {
		long time = System.currentTimeMillis();
		Date date = new Date(time);
		int min = date.getMinutes();
		
		return min;
	}
	
	int getSeconds() {
		Date date = Calendar.getInstance().getTime();
		int sec = date.getSeconds();
		
		return sec;
	}
}

class ForeignClock extends Clock{
	String location;
	int timeDiff;
	
	public String getLocation() { return location;}
	public ForeignClock (String loc, int diff) { location = loc;
	timeDiff = diff;}
	
	int getHours() {
		int local = super.getHours();
		
		int tmp = local + timeDiff;
		tmp = (tmp < 0) ? (24 + tmp ) : tmp;
		return tmp;
	}
}

