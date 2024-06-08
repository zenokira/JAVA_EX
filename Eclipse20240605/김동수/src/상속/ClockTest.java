package 상속;

public class ClockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clock[] clocks = new Clock[3];
		clocks[0] = new Clock();
		clocks[1] = new ForeignClock("Rome", 9);
		clocks[2] = new ForeignClock("Tokyo", - 7);
		
		
		/*Clock korClock = new Clock();
		Clock romeClock = new ForeignClock("Rome", 9);
		Clock tokyoClock = new ForeignClock("Tokyo", - 7);
		*/
		
		
		for( Clock c : clocks)
		{
			System.out.println(c.getLocation() + " : " +
					c.getHours() + "시 " + 
					c.getMinutes() + "분 " + 
					c.getSeconds() + "초 ");
		}
		
		/*
		 * System.out.println(korClock.getLocation() + " : " + korClock.getHours() +
		 * "시 " + korClock.getMinutes() + "분 " + korClock.getSeconds() + "초 ");
		 * System.out.println(romeClock.getLocation() + " : " + romeClock.getHours() +
		 * "시 " + romeClock.getMinutes() + "분 " + romeClock.getSeconds() + "초 ");
		 * System.out.println(tokyoClock.getLocation() + " : " + tokyoClock.getHours() +
		 * "시 " + tokyoClock.getMinutes() + "분 " + tokyoClock.getSeconds() + "초 ");
		 */		
	}

}
