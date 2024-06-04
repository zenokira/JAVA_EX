package String_ex;

public class str_format {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String depart = "컴공";
		int max = 10, min = 5;
		float avg = 7.5f;
		String formatStr = "학과 %s - 최댓값 : %d , 최솟값 : %d , 평균 : %f";
		System.out.printf(formatStr, depart, max, min, avg);
	}

}
