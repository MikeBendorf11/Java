package a_thisSuper;

public class CoinCounter {
	public static void main(String[]args){
		Counter tail = new Counter();
		Counter head = new Counter();
		for (int i=0;i<100;i++){
			if (Math.random()<0.5){
				tail.increment();
			}
			else{
				head.increment();
			}
		}
		System.out.println("Number of tails: " + tail.getInitialVal());
		System.out.println("Number of heads: " + head.getInitialVal());
	}
}
