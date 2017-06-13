package d_aboutClasses;
/*this will calculate max min average and deviation from an 
 * rolling dice experiment. Two pairs of dice are rolled until both 
 * are equal to a given number [from 2 (two ones) to 12 (two sixes)]
 * This experiment is repeated to a number specified by the user
 * */
public class diceStat {
	static int nToObtain; //number to be obtained from each pair
	static int nExperiments; // number of times the experiment will be held
	static int rollCounter; // counts the number of rolls until the boolean condition is met
	static StatCalc casinoStat = new StatCalc();
	
	public static void main(String[]args){
		TextIO.put("Number each pair of dice " +
				"will be equal to: ");
		nToObtain = TextIO.getInt(); 
		TextIO.put("Number of times the  " +
		"experiment will be repeated: ");
		nExperiments = TextIO.getInt(); 
		rollCalculator();
		System.out.println("- Maximun Value: 	" + (int)(casinoStat.getMax()));
		System.out.println("- Minimun Value: 	"+ (int)(casinoStat.getMin()));
		System.out.println("- Average: 		" + (int)(casinoStat.getMean()));
		System.out.println("- Standard:		"+ (int)(casinoStat.getStandardDeviation())+
				"\n  Deviation ");
	}
	public static void diceRoller(){
		/*rolls two pairs of dice until the number obtained
		 * from both of them is equal to the user input*/
		PairOfDice firstPair = new PairOfDice();
		PairOfDice secondPair = new PairOfDice();
		rollCounter=0;
		int total1;
		int total2;
		// one roll is considered the roll of two pairs of dices
		// at the same time
		do{
			firstPair.roll();
			secondPair.roll();
			total1=firstPair.getDie1()+firstPair.getDie2();
			total2=secondPair.getDie1()+secondPair.getDie2();
			rollCounter++;
			// boolean equivalent is !(t1==input && t2==input)
		}while(total1!=nToObtain || total2!=nToObtain); 
	}
	public static void rollCalculator(){
		//number of times the test is going to be held
		for (int i=0;i<nExperiments;i++){
			diceRoller();
			casinoStat.enter((double)(rollCounter));
			}	
	}
}
