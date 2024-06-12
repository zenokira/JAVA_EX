package 토큰;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File gradeFile = new File("c:\\temp\\scores.txt");
			
			Scanner inFile = new Scanner(gradeFile);
			
			while ( inFile.hasNextLine())
			{
				String line = inFile.nextLine();
				String [] st = line.split("[:]+");
				
				double sum = 0;
				
				for (int n =1; n < st.length; n++)
				{
					sum += Integer.parseInt(st[n]);
				}
				
				System.out.printf("%s %5.2f\n", "평균 ", sum/(st.length - 1));
			}
			inFile.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
