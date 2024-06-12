package 파일;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\sw\\eclipse-workspace\\20240612\\test2.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			
			boolean b = false;
			double d = 165.8;
			String str = "This is a test.";
			
			dos.writeBoolean(b);
			dos.writeDouble(d);
			dos.writeChars(str);
			
			dos.close();
			System.out.println("성공적으로 쓰기를 마쳤습니다.");
			
			FileInputStream fis = new FileInputStream("C:\\Users\\sw\\eclipse-workspace\\20240612\\test2.txt");
			DataInputStream dis = new DataInputStream(fis);
			
			boolean b2 = dis.readBoolean();
			System.out.println(b2);
			double d2 = dis.readDouble();
			System.out.println(d2);
			char c;
			while (dis.available() > 0) {
				c = dis.readChar();
				System.out.print(c);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
