package a_initial;
import java.util.Random;
public class diceGuess {
	static int wish;
	/*had to be set like this so wish can be used
	 * within the 10000 average loop*/
	static Boolean printData = true;
	/*Controls whether random generated data is printed or not
	 * good for when calculating the 10,000 average*/
	
	public static void main(String[]args){
		Boolean isRunning = true;
		
		while (isRunning){
			TextIO.put("What number do you want to obtain from your rolling dice? ");
			wish=TextIO.getInt();
			int times = rolling(wish);	
			/*wanted to set this variable just to prove that the 
			 * return value of the rolling subroutine is valid added
			 * at the end of it*/
			TextIO.put("Times rolled: " + times);
			TextIO.put("\nDo you want to roll again? ");
			isRunning = TextIO.getBoolean();	
		}//end of while is Running, start of 10,000 average message
		if (!isRunning);{TextIO.put("Thanks for using the DICE ROLLER!");
		printData=false;//stop the printing lines on rolling subroutine
		}	
		int average = 0;
		int tries = 10000;
		for (int i=1;i<tries;i++){
			// circles through 10,000 cycles and adds up
			average += rolling(wish);
		}
		
		TextIO.put("\n10000 average is " + average/tries + " times");
	}
	public static int rolling(int A){ 
		/*Had to change from void to int so I can establish a return 
		 * value for the main subroutine*/
		Random roller1 = new Random();
		Random roller2 = new Random();
		int nSoFar;
		int rollingTimes=0;
		Boolean isRolling = true;
		
		while(isRolling){
			int roll1=roller1.nextInt(7);
			int roll2=roller2.nextInt(7);
	
			if (roll1>0&&roll2>0){
				/*ignores 0 values from the random generators
				 *roller1.nextInt(7) will generate 7 values from 
				 *0 to 6 */
				nSoFar =  roll1 + roll2;
				rollingTimes++;
				
				if (printData&&rollingTimes%5==0){
					//format help 5 calcs per line
					TextIO.put("\n");
					}
				if(printData){ 
					// prints the calculations
					TextIO.put(roll1 + "+" +roll2 + "=" + nSoFar+ ", ");
				}
				if (nSoFar==A){ 
					// stop the rolling once the wish value is found
					isRolling=false;
					}
				}
			}
		return rollingTimes;
		}
	}
