package d_aboutClasses;

public class RollTwoDice {
	public static void main(String[] args) {
		PairOfDice firstPair = new PairOfDice();
		
		PairOfDice secondPair= new PairOfDice(3,6);
		
		firstPair.roll();
		System.out.println("A sample of die1.firstPair value using getter method: "+firstPair.getDie1());
		System.out.println("A sample of die2.firstPair value using getter method: "+firstPair.getDie2());
		System.out.println("SecondPair die1 fixed value: "+secondPair.getDie1());
		System.out.println("SecondPair die2 fixed value: "+secondPair.getDie2());
		//firstPair.die1=0; error, since die1 is private on PairOfDice Class
		
		int counter=0;
		int total1;
		int total2;
		do{
			total1=firstPair.getDie1()+firstPair.getDie2();
			total2=secondPair.getDie1()+secondPair.getDie2();
			counter++;
			firstPair.roll();
		}while(total1!=total2);
		System.out.println("Rolled this many times to get the two pairs equal: " + counter);
	}
}