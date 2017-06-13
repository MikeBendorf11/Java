package d_aboutClasses;

public class PairOfDice {
	private int die1; 
	private int die2;
	
	public PairOfDice(){ //default contructor
		roll();
	}
	public PairOfDice(int A, int B){
		die1=A;		//predetermined val 
		die2=B;			// constructor
	}
	public int getDie1() {
		return die1;
	}
	public int getDie2() {
		return die2;
	}
	public void roll (){
			die1 = (int)(Math.random()*6)+1;
			die2 = (int)(Math.random()*6)+1;
		}
	}

