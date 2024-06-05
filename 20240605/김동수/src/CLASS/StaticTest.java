package CLASS;

public class StaticTest {
	static int value;
	int instVal;
//	void setValue(int n ) { value = n; }
//	int getValue() { return value;}
	void setInstVal(int n ) { instVal = n;}
	int getInstVal() {return instVal;}
	
	static void setValue(int n ) { value = n; }
	static int getValue() { return value;}
}
