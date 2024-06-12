package 문자스트림;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ProgramBasicTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream out = null;
		OutputStreamWriter fout = null;
		double d = 32.3;
		
		try {
			out = new FileOutputStream("C:\\Users\\sw\\eclipse-workspace\\20240612\\hangul.txt");
			fout = new OutputStreamWriter(out, "UTF-16");
			
			fout.write("한글 ");
			fout.write(Double.toString(d));
			
			fout.close();
			System.out.println("성공적으로 쓰기를 마쳤습니다.");
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
