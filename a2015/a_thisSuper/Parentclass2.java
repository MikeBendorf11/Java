package a_thisSuper;
// super() to invoke constructor of parent class 	explicitly

class Parentclass2
{
   Parentclass2(){
   System.out.println("Constructor of Superclass2");
   }
}
class Subclass2 extends Parentclass2
{
   Subclass2(){
	super(); 	//calling constructor parent method, gotta be the first call on subclass constructor
	System.out.println("Constructor of Subclass2");
   }
   void display(){
	System.out.println("Hello2");
   }
   public static void main(String args[]){		
	Subclass2 obj2= new Subclass2();
    obj2.display();	 
   }
}
//PRINTS
/*Constructor of Superclass2
Constructor of Subclass2
Hello2
*/