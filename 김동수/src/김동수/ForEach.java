package 김동수;

public class ForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = { 88, 67, 56, 77, 99, 90, 44};
		
		double avg;
		
		int max = 0, min = 100, sum = 0;
		
		for ( int number : array) {
			sum += number;
			if (number > max) max = number;
			if ( number < min ) min = number;		
		}
		
		avg = ((double)sum) / array.length;
		System.out.println("평균 : " + avg);
		System.out.println("최고 : " + max);
		System.out.println("최저 : " + min);
		
	}
}
