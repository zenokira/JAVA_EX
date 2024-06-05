package CLASS;

public class StudentInfo {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int korSum = 0, engSum = 0, mathSum = 0;
		
		double totalSum =0.0, korAvg, engAvg, mathAvg, totalAvg;
		
		Student [] students = new Student[3];
		
		students[0] = new Student();
		students[0].setInfo("bmkim1", 2016001, 70, 80, 90);
		students[0].count++;
		students[1] = new Student();
		students[1].setInfo("bmkim2", 2016002, 60, 70, 80);
		students[1].count++;
		students[2] = new Student();
		students[2].setInfo("bmkim3", 2016003, 50, 60, 70);
		students[2].count++;
				
		for ( int i = 0; i < 3; i++)
		{
			System.out.println(students[i].getInfo());
			korSum += students[i].kor;
			engSum += students[i].eng;
			mathSum += students[i].math;
			totalSum += students[i].getAverage();
		}
		
		korAvg = korSum / 3.0;
		engAvg = engSum / 3.0;
		mathAvg = mathSum / 3.0;
		totalAvg = totalSum / 3.0;
		
		System.out.println("국어 평균 : " + korAvg);
		System.out.println("영어 평균 : " + engAvg);
		System.out.println("수학 평균 : " + mathAvg);
		System.out.println("전체 평균 : " + totalAvg);
		
	}

}

