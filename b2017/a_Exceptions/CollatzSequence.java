package a_Exceptions;

import java.math.BigInteger;
import java.util.Scanner;

public class CollatzSequence {
	public class myExceptions extends Exception{
		public myExceptions(String msg){ //constructor
			super(msg);
		}
	}

	public static void main(String[] args) {
		/*
		 * if odd 3n+1, if even n/2
		 * 
		 * BigInteger Throws:
    NumberFormatException - val is not a valid representation 
    of a BigInteger in the specified radix, or radix is outside 
    the range from Character.MIN_RADIX to Character.MAX_RADIX, inclusive.
		 */
    	System.out.println("Character.MIN_RADIX:"+Character.MIN_RADIX);
    	System.out.println("Character.MIN_RADIX:"+Character.MAX_RADIX);
    	
		String n;
		BigInteger N;
		Scanner sc = new Scanner(System.in);
	    
	    while(true){

		    System.out.println("Enter a big integer: ");
		    n = sc.nextLine();
		    try {
		    	chucha(n);
				toBigInt(n);
			} catch (myExceptions e) {
				System.out.println("Error: " + e.getMessage());
			}

	    }
	}
	static String chucha (String a){
		return a;	
	}
	
	static BigInteger toBigInt(String n) throws myExceptions{
		for(int i=0;i<n.length();i++)
		{
		   if(!Character.isDigit(n.charAt(i))){
			   throw new myExceptions("Error: Only numbers allowed");
		   }
		   
		}
		
		

		BigInteger N = new BigInteger(n);
		System.out.println("Your number: " + N);
		return N;
	}

}
