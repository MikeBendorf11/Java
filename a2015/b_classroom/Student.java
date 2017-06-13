package b_classroom;
import java.util.*;

	public class Student {

		   public String name;  // Student's name.
		   public double test1, test2, test3;   // Grades on three tests.
		   
		   public double getAverage() {  // compute average test grade
		      return (test1 + test2 + test3) / 3;
		   }
		   
		  // end of class Student
	public static void main(String[]args){
		Student A00908236 = new Student();
		Student quechuchas = null;
		A00908236.name="Tupapa";
		A00908236.test1=10.5;
		
	
		Student[] classlist = new Student[2];
		
		    classlist[1] = new Student();
				classlist[1].name="mario";
				
		  //each element of the array has to be declared as part of Student class
			
			
		 System.out.println("classlist[1] name lenght: " +classlist[1].name.length());
		 System.out.println("classlist[0] name lenght: " +classlist[0].name);
		 System.out.println("classlist[0] test: " +classlist[0].test1);
		
		 String []loco = new String[30];
		 loco[1]="desquiciado";
		 System.out.println("loco name lenght: " +loco[1].length());
		 
		System.exit(0);
		
		
		// quechuchas.test2=5.5 will give an error
		
	}
}
