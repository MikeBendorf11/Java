package k_console;
public class hexCalc extends ConsoleApplet  {
	/* Had to be declared as static so
	 * has they could be included on the other
	 * subroutines bellow
	 * */
	static double total = 0;
	static boolean isRunning = true;//this variable was unnecessary
	
	 protected String getTitle() {
	      return "Sample program \"HEX to Decimal Calc\"";
	   }

	   protected void program() {
	
	while (isRunning){
		console.put("\nPlease enter a HEX value OR -1 to terminate: ");
		String userInput = console.getln();
		hexValue(userInput); 
		/* as long as the parameter here (useInput) is of the type String
		 * hexValue subroutine will be executed correctly because 
		 * String UserInput = String str declared bellow  
		 */
		console.put(total);
		}
	}
	public  void hexValue(String str) {
		total = 0;
		int exponent = 0;
		// scan letters from left (charPosition) and count down to 0
		for ( int charPosition = str.length();charPosition>0;charPosition--){ 
			char hexChar = str.charAt(charPosition-1);
			int tempVal=0;
		/*Assigned values for letters
		* works with small letters as well is caps
		* I don't know why
		*/ 
			if (hexChar=='a'){
				tempVal= 10;
			}
			else if (hexChar=='b'){
				tempVal= 11;
			}
			else if (hexChar=='c'){
				tempVal= 12;
			}
			else if (hexChar=='d'){
				tempVal= 13;
			}
			else if (hexChar=='e'){
				tempVal= 14;
			}
			else if (hexChar=='f'){
				tempVal= 15;
			}
				// evaluates if user entered -1 in order to terminate the program
			else if (Character.getNumericValue(hexChar)<0){ 
			console.put("Thanks for using the HEX Converter ");
			isRunning = false; // prophylactic measure
			System.exit(0); // if not this then it ill always print 1.0 at the end
			}
			else{
				// evaluates any number on the input from 0 to 9 and takes the real value 
				tempVal = Character.getNumericValue(hexChar);
			}
			// adds up to the total what has been calculated from before
			total += tempVal * Math.pow(16,exponent);
			exponent++;
			
		}
		
		
	}
}
