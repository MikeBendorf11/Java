package a_Exceptions;

public class Quadratic {
	 static class IllegalArgumentException extends Exception {
         // This nested class is used to represent errors in the
         // user's input.
		 IllegalArgumentException(String message) {
         super(message);
      }
   }
	public static void main(String[] args) {
		double a, b, c;
		TextIO.putln("Enter a:");
		a = TextIO.getlnDouble();
		TextIO.putln("Enter b:");
		b = TextIO.getlnDouble();
		TextIO.putln("Enter c:");
		c = TextIO.getlnDouble();
		try{
			TextIO.putln(root(a,b,c));
		}
		catch (IllegalArgumentException i){
			TextIO.putln( "Error:  " + i.getMessage() );
		}
		
	}
	static double root(double A, double B, double C) throws IllegalArgumentException {
		// Returns the larger of the two roots of
		// the quadratic equation A*x*x + B*x + C = 0.
		// (Throws an exception if A == 0 or B*B-4*A*C < 0.)
		if (A == 0) {
			throw new IllegalArgumentException("A can't be zero.");
		} else {
			double disc = B * B - 4 * A * C;
			if (disc < 0)
				throw new IllegalArgumentException("Discriminant < zero.");
			return (-B + Math.sqrt(disc)) / (2 * A);
		}
	}
}