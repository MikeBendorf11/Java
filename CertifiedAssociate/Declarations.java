package associate;

class A{} class B{}

public class Declarations {
	public static void main(String[] args) {
		boolean one  = true|false;
		boolean two = true||false;
		System.out.println("One: " + one + "//" + "Two: " + two);;
		
		test1(); //send from 0 to more array values (1,77,3)
		test2(null); //null is a type 
		
		short s = -32000; //16-bit
		Short s1 = new Short((short)2); //exceptions
		Byte bb = new Byte((byte)2);
		char c = 64000; //16-bit 
		int i = 1;	//32-bit
		long l = -2; // 64-bit
		//Long l2 = new Long(32.2);
		double d = 1.2f;
		//float f = 24.0d;
		Float f1 = new Float(2);
		
		i=c; i=c; l=i;
		
		//wrapper
		Long lg = new Long(1); //or 1L
		//lg.equals(1L) not the same as below
		System.out.println("lg.equals(1) is " + lg.equals(1));
		
		//statements
		if(d==f1); //(false==null) bad (null==null) good
		//l==1; 1; false; null; //compile fail
		A a = new A(); 	B b = new B(); A a2 = new A();
		a.equals(b); //equals takes whatever
		//if(a==b); 
		
		int []n = new int[1];
		System.out.println("n[0] = " + n[0]);
		//System.out.println(yeah());
		int [] nu = new int[i=2];
		int [] xx = new int[] {1,2,3};
		int ab = 1;
		ab += (ab = 4) * (ab +2);
		System.out.println("ab = " + ab);			
	}
	public static void yeah() {}
	public static void test1(int... i){
		System.out.println(i.length);
	}
	public static void test2(String s) {
		//s.length(); crashes
	}
}
