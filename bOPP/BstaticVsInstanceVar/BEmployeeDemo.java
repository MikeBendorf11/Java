package BstaticVsInstanceVar;

public class BEmployeeDemo {
	 public static void main(String[] args) {
		/*If below line doesn't exists then 10 is the 
		 * default value*/
		BEmployee.vacationDays = 15;
		
	 	BEmployee e1 = new BEmployee();
	 	// Change bellow results in 20 for e1 and e2
	 	//e1.vacationDays = 20;
	 	e1.code = 666;
        BEmployee e2 = new BEmployee();
        
        e1.print();
        e2.print();
        /* Prints:
        Vacation Days: 15
        Code: 666
        Vacation Days: 15
        Code: 0
        */
	 }
}
