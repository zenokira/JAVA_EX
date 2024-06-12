package 파일;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream out = new FileOutputStream("C:\\Users\\sw\\eclipse-workspace\\20240612\\test.out");

			int num[] = {2,3,-2,87,351};
			byte b[] = {7,50,3,4,1,24};
			
			for(int i = 0; i <num.length ; i++)
				out.write(num[i]); 
			out.write(b);
			out.close();
			System.out.println("성공적으로 마쳤습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
