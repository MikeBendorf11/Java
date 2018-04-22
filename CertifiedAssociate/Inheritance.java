//import java.util.*;
package associate;

class X{ 
	int shadowNumber = 666;
	int number = 777;
	X(int i){} //explicit, not called "default"
	public void dostuff(){
		System.out.println("yay");
	}
	public void doMore(double x) {
		System.out.println("In X");
	}
}
class Y extends X{
	int shadowNumber = 888; //another n
	Y(){super(0);}
	Y(String s){this();} //either super or this not both
	Y(int i, int b){super(b);} 
	public void dostuff(String x){
		System.out.println("yay" + x);
	}
	public void doMore(double x) {
		System.out.println("In Y");
	}
}
class Z{} //for instanceof test
 class Inheritance {
	public static void main(String[] args) {
	
		X x = new Y();
		x.dostuff();
		x.doMore(1.1);
		((X)x).doMore(1.5);
		Y y = (Y)x; 
		y.dostuff();
		y.dostuff("rrrrr");
		
		Y otherY = new Y();
		System.out.println("otherB = " + otherY.number); 
		System.out.println("otherB = " + otherY.shadowNumber);
		
		X otherX = new Y();
		if(otherX instanceof Y) System.out.println("instanceOf");;
	}	

}
