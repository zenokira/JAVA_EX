package 직렬화;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;
import java.util.Iterator;

public class ProgramBasicTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student1 s1 = new Student1(2011, "홍길동", "경북 구미시");
		Student1 s2 = new Student1(2011, "장길산", "서울 도봉구");

		Vector v = new Vector();
		v.add(s1);
		v.add(s2);

		try {
			FileOutputStream fos = new FileOutputStream
					(new File("C:\\Temp\\test3.txt"));
			
			ObjectOutputStream oos = 
					new ObjectOutputStream(fos);
			
			oos.writeObject(v);
			System.out.println("성공적으로 마쳤습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		v.clear();
		
		try {
			FileInputStream fis = new FileInputStream
					(new File("C:\\temp\\test3.txt"));
			
			ObjectInputStream ois = 
					new ObjectInputStream(fis);
			
			v = (Vector) ois.readObject();
			Iterator it = v.iterator();

			while (it.hasNext()) {
				Student1 s = (Student1) it.next();
				System.out.println(
						s.getID() + s.getName() + s.getAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class Student1 implements Serializable {
	String name;
	transient int id;
	String address;

	public Student1(int id, String name, String add) {
		this.id = id;
		this.name = name;
		this.address = add;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

}