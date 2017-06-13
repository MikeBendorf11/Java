package b_classroom;
public class Student1 {

    String name;                 // Student's name.
    double test1, test2, test3;   // Grades on three tests.
   
   public Student1(String name) {
        // Constructor for Student objects;
        // provides a name for the Student.
        // The name can't be null.
      if ( name == null )
          throw new IllegalArgumentException("name can't be null");
      this.name = name;
   }
   
   public String getName() {
        // Getter method for reading the value of the private
        // instance variable, name.
      return name;
   }
   
   public double getAverage() { 
        // Compute average test grade.
      return (test1 + test2 + test3) / 3;
   }
   
	public static void main(String[]args){
		
		Student1 a9082 = new Student1("Carlos");
		Student1 quechuchas = new Student1("locodice");
		System.out.println(a9082.name);
		a9082.getAverage();
	}

}  // end of class Student