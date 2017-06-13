package a_thisSuper;
public class constructors {
	int dieA;
	int dieB = 33;
	public constructors(){			// changes only dieA
		dieA = 20; 
	}
	public constructors(int die5){
		this.dieA=die5;		//remove this has same results from here on
	}
	public constructors(int die5, int die6){ // changes both dies
		this.dieA=die5;
		this.dieB=die6;
	}
	public static void main(String[]args){
		constructors obj = new constructors();
		TextIO.putln("Method One:");
		TextIO.putln(obj.dieA);
		TextIO.putln(obj.dieB); 		// dieB default value will be printed
		
		constructors obj2 = new constructors(11);
		TextIO.putln("Method Two:");
		TextIO.putln(obj2.dieA);
		TextIO.putln(obj2.dieB);
		
		constructors obj3 = new constructors(55,66);
		TextIO.putln("Method Three:");
		TextIO.putln(obj3.dieA);
		TextIO.putln(obj3.dieB);
	}
}
