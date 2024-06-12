package 문자스트림;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ProgramBasicTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			System.out.println(">> ");
			InputStreamReader in = new InputStreamReader(System.in);
			
			FileWriter fout = null;
			int c;
			
			fout  = new FileWriter("C:\\Users\\sw\\eclipse-workspace\\20240612\\test3.txt");
			while ( (c = in.read()) != 13) {
				fout.write(c);
			}
			in.close();
			fout.close();
			System.out.println("성공적으로 쓰기를 마쳤습니다.");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
