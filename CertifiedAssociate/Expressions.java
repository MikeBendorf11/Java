package associate;

public class Expressions {

	public static void main(String[] args) {
		int a, b, c;
		
		/*++ prefix or suffix creates a group with the 
		 * itself and then within the group:
		 * 		++ prefix executes then writes values
		 * 		++ postfix writes values then executes
		 * for a different value than it self
		 * 		see equivalent expression
		 * note: parenthesis irrelevant for addition*/
		b=2; 
		a = b + b + ++b + b;
		System.out.println("1. A? " + a);
		b=2; c = 2;
		a = b++ + b + b + b; //replace with c not the same
		System.out.println("2. A? " + a + " B? " + b);
		b=1;
		b += (b++ +2)*(b=4);
		System.out.println("1. B? " + b);
		b=1;
		b = b + ((b+2)+(0*(b=b+1))) * (b=4); //equivalent to above
		System.out.println("2. B? " + b);
		b=1;
		b += (b++ +(b+1))*(b=4); //but..
		System.out.println("3. B? " + b);
		c=1; c = (c++ + (c+1))* c;
		System.out.println("1. C? " + c);
		c=1; c = (c++ + 2)* c;
		System.out.println("2. C? " + c);
		
		float f = 1.5f/1;
		double d = 3.8/2;  // double 64-bit
		int i = (int)(1.2f+4.9);
		float d2 = (float)(f/d);

		d = i; 
		f = i; 

		if (1==1.0000001f) //float takes up to 10 e-7
			System.out.println("yes?");
		
		int r=1, t, y;
		int [] k = new int [1];
		System.out.println("k[0]="+k[0]);
	}

}
