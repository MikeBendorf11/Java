package a_thisSuper;
// super.<method_name> to invoke parent class method


class Parentclass3
{
   //Overridden method
   void display3(){
	System.out.println("Parent class method");
   }
}
class Subclass3 extends Parentclass3
{
   //Overriding method
   void display3(){
	System.out.println("Child class method");
   }
   void printMsg3(){
	//This would call Overriding method
	display3();
	//This would call Overridden method
	super.display3();
   }
   public static void main(String args[]){		
	Subclass3 obj3= new Subclass3();
	obj3.printMsg3(); 
   }
}
/*
PRINTS
/*
 * Child class method
Parent class method 123456•89..123456
 */
