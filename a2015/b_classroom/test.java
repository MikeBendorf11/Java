package b_classroom;

public class test {
	public int die1=10;
	static void dontChange(int z) {  
		 z = 42; 
		 System.out.println("z= "+z);
	}
	public test(){
		die1 = 4; // constructor overrides default value•
	}
	public test(int A){
		A=die1;		// constructor returns the default value of die1=10
	
	}
	public test(double B){
		B=die1;
	
	}
	
	public static void main(String[]args){
		test firsttest = new test();
		  System.out.println("1st die1= "+ firsttest.die1);
		test secondtest = new test(0);
		  System.out.println("2nd die1= "+ secondtest.die1);
		 test thirdtest = new test();
		  System.out.println("3rd die1= "+ thirdtest.die1);
		test fourthtest = new test(2.2);
		  System.out.println("4th die1= "+ fourthtest.die1);
		  
		  int x = 0;  
		  dontChange(x); 
		  System.out.println("x value: "+x);
		  		  
		  int[] list = new int[3];
		  int[] newlist= new int[3]; 
		  list[1] = 17;
		  newlist[1] = 42;
		  list=newlist; // list is overwritten by new-list values, if i invert this results invert (17)
		  
		 
		  System.out.println("list[1]= " +list[1] + " newlist[1]= " +newlist[1]);
		  int a = 12;
		  int b = 11;
		  b = a; // result 11 if a = b because of clock cycle
		  System.out.println("The valuo of a: " +a +" The value of b: " +b);
		
	}
}
