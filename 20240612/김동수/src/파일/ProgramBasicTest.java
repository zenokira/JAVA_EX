package 파일;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProgramBasicTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream out = new FileOutputStream("C:\\Users\\sw\\eclipse-workspace\\20240612\\test.out");

			int num[] = {2,3,-2,87,351};
			byte b[] = {7,50,3,4,1,-2};
			
			for(int i = 0; i <num.length ; i++)
				out.write(num[i]); 
			out.write(b);
			out.close();
			System.out.println("성공적으로 마쳤습니다.");
			
			FileInputStream in = new FileInputStream("C:\\Users\\sw\\eclipse-workspace\\20240612\\test.out");
			
			int c;
			for(int i = 0; i < num.length; i++) {
				c = in.read();
				System.out.println(c);
			}
			
			byte[] d = new byte[6];
			in.read(d);
			for(int i = 0; i <d.length; i++) {
				System.out.println(d[i]);
			}
			in.close();
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
