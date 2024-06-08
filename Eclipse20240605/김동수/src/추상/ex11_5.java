package 추상;

public class ex11_5 {

}

interface Car {
	public void showInfo();
}

class PassengerCar implements Car {
	private int seats;

	public PassengerCar() { // 3
		seats = 2;			// 4
	} 

	public PassengerCar(int n) { // 10
		seats = n; // 11
	} 

	public int getSeats() { // 28
		return seats; //29
	}

	public void setSeats(int n) {
		seats = n;
	}

	public void showInfo() { //18
		System.out.println("좌석 수 : " + seats); //19
	}
}

class Truck implements ITruck {
	private int payload;

	public Truck() {
		payload = 100;
	}

	public Truck(int n) { //6 13
		payload = n;      //7 14
	}

	public int getPayload() { //33
		return payload;  //34
	}

	public void setPayload(int n) {
		payload = n;
	}

	public void showInfo() { // 22
		System.out.println("적재 하중 : " + payload); //23
	}
}

interface ITruck extends Car { // 7
	public int getPayload();

	public void setPayload(int w);
}

class Pickup extends PassengerCar implements ITruck {
	private int tow_capacity;
	Truck truck;

	public Pickup() {
		super(4);
		truck = new Truck(1000);
		tow_capacity = 10000;
	}

	public Pickup(int s, int w, int c) { 
		super(s); //9
		truck = new Truck(w); // 12
		tow_capacity = c;  // 15
	} 

	public void setCapacity(int c) {
		tow_capacity = c;
	}

	public int getCapacity() {
		return tow_capacity;
	}

	public void showInfo() { //26
		System.out.println("좌석 수 : " + getSeats() + ", 적재 하중 : "  //27
		 + getPayload() + ", 견인 능력 : " + tow_capacity);// 30
	}

	@Override
	public int getPayload() {//31
		return truck.getPayload(); //32
	}

	@Override
	public void setPayload(int w) {
		truck.setPayload(w);
	}
}