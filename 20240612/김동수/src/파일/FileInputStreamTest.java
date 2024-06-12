package 파일;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		FileInputStream in = new FileInputStream("C:\\Users\\sw\\eclipse-workspace\\20240612\\test.txt");
		
		int c;
		while ((c = in.read()) != -1 )
		{
			System.out.println((char)c);
		}
		
		in.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
