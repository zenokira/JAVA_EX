package 스캐너;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserExceptionTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			File in = new File("c:\\temp\\test.txt");
			
			Scanner sc = new Scanner(in);
			String str = sc.nextLine();
			int i = Integer.parseInt(str);
			String s = sc.nextLine();
			System.out.println(i + ", " + s);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
