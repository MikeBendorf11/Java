package a_Exceptions;

import java.math.BigInteger;
import java.util.Scanner;

public class CollatzSequence {
	
	/* If instance then is inner, if static then is nested.
	 * Method call for transform(); was giving error related
	 * with not having an instance of Collatz Sequence.
	 * 
	 * BigInteger Throws:NumberFormatException - val is not a valid
	 * representation of a BigInteger in the specified radix.
	 * */
	public static class myExceptions extends Exception{
		public myExceptions(String msg){ //constructor
			super(msg);
		}
	}

	public static void main(String[] args) {
		String s;
		BigInteger N;
		Scanner sc = new Scanner(System.in);
	    
	    while(true){

		    System.out.println("Enter as big as a positive number as you can: "
		    		+ "(Empty line to exit)");
		    s = sc.nextLine();
		    if(s.equals("")) System.exit(0);
		    
		    try {
		    	N=transform(s);
		    	sequence(N);
		    	System.out.println(
		    	"The Collatz Sequence is generated from this formula: \n" +
		    			"a) 3n + 1 if the number is odd\n" +
		    			"b) n / 2 if the number is even\n" + 
		    			"c) Continue until reaching 1");
			} catch (myExceptions e) {
				System.out.println("Error: " + e.getMessage());
			}
	    }
	}
	
 	static BigInteger transform(String s) throws myExceptions{	
		BigInteger N;
		
		if(testCh(s)){
			/* Thrown is like a return
			 * Then an immediate "else{return x;}" alternative has 
			 * to be offered for "transform();" to be complete*/
			throw new myExceptions("Invalid Digit Input!");
		} else {
			N = new BigInteger(s);
			return N;
		}			
	}
 	
 	static void sequence(BigInteger N){
 		BigInteger N1 = new BigInteger("1");
 		BigInteger N2 = new BigInteger("2");
 		BigInteger N3 = new BigInteger("3"); 
 		
 		while (!N.equals(N1)){
 	 		if (N.testBit(0)){
 	 			N =  N1.add(N.multiply(N3));			
 	 		} else {
 	 			N = N.divide(N2);
 	 		}
 	 		System.out.println(N);
 		}
 	}
 	
	static Boolean testCh(String s){	
		Boolean b=false;
		for(int i=0;i<s.length();i++)
		{
		   if(!Character.isDigit(s.charAt(i))){
			   b=true;
		   }
		}
		return b;
	}
	
	

}

