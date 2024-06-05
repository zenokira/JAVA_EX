package CLASS;

public class Student {
	String sname;
	int sid, kor, eng, math;
	
	static int count = 0;
	
	void setInfo(String name, int id, int k, int e, int m)
	{
		this.sname = name; this.sid = id; this.kor = k; this.eng = e; this.math = m;
	}
	double getAverage() { return (this.kor + this.eng + this.math) / 3.0;}
	String getInfo() { return this.sname + ", " + this.sid + ", " + this.kor + ", " + this.eng + ", " + this.math;}
	
}
