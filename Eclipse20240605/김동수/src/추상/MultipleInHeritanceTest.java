package 추상;

public class MultipleInHeritanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car[] cars = new Car[3]; // 1

		cars[0] = new PassengerCar(); // 2
		cars[1] = new Truck(500); // 5
		cars[2] = new Pickup(4, 2000, 10000); // 8

		for (int i = 0; i < 3; i++) // 16 20 24 35
		{
			cars[i].showInfo(); // 17 21 25
		}
	} 

}
