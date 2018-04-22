package AfollowsTheObj;

public class AEmployeeDemo {
    public static void main(String[] args) {
    	 
         AEmployee e2 = new AEmployee();
         
         int x = 1974;
         e2.setYearOfBirth(x);
         
         // prints 1974, yOB var from set considered
         System.out.println(e2.yearOfBirth); 
         // prints 1974, x from set ignored
         System.out.println(x);          

    }

}
