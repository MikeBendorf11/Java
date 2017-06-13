package BstaticVsInstanceVar;

public class BEmployee {
	/* IMPORTANT
	 * Value is stored in the heap and its shared
	 * by all objects of the Employee class*/
	static int vacationDays = 10;
	
	/* IMPORTANT
	 * Instance var, Unique to each instance 
	 * (object) of the class*/
	int code;

    void print() {
    	System.out.println("Vacation Days: " + vacationDays);
    	System.out.println("Code: " + code);
    }

}
