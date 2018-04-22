package associate;

public class Overloading {
	
	int test1(int i, float f, double b){return i;}
	int test1(float f, int i, double b) {return i;}
	float test1(double b, int i, float f) {return i;}
	double test1(int i, int b, int c) {return i;}
	
	public static void main(String[] args) {
	Overloading o = new Overloading();	
	o.test1(1f,2, 3.0);
	
	float f2 = 1;
	double d2 = new Integer(0);
	o.test1(d2,2,f2);
	o.test1(1, 1, 4);
	}
}
