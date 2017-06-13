package a_thisSuper;

public class Counter {
	private int initialVal;
	public Counter(){
		initialVal=0;
	}	
	//removing "this" seems to have the same effect??
	public Counter(int initialVal){ 
		this.initialVal = initialVal;
	}
	public int getInitialVal() {
		return initialVal;
	}
	public void increment(){
		initialVal++;
	}
}
