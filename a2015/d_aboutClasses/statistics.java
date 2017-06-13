package d_aboutClasses;

public class statistics {
	public static void main(String[] args) {
		Boolean isRunning=true;
		StatCalc mycalc = new StatCalc();
		System.out.println("STATCALC 1.0, enter 0 to terminate program");
		while (isRunning){
			System.out.println("Enter a value: ");
			double value=TextIO.getDouble();
			mycalc.enter(value);
			if (value==0){
				isRunning=false;
			}	
		}
		System.out.println("Maximun Value: " + mycalc.getMax());
		System.out.println("Minimun Value: "+ mycalc.getMin());
		System.out.println("Average: " + mycalc.getMean());
		System.out.println("Standard Deviation: " 
				+ mycalc.getStandardDeviation());
	}
}
