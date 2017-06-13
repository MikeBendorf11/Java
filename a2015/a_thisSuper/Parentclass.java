package a_thisSuper;
// super() to invoke constructor of parent class

class Parentclass {
	   Parentclass(){
	      System.out.println("Constructor of Superclass");
	      }
	}
	class Subclass extends Parentclass{
	   Subclass(){
		System.out.println("Constructor of Subclass");//super added implicitly here means it calls superclass while printing
	   }
	   Subclass(int num){
		System.out.println("Constructor with arg"); //super added implicitly here means it calls superclass while printing
	   }
	   void display(){
		System.out.println("Hello");
	   }
	   public static void main(String args[]){
		Subclass obj= new Subclass();
	       obj.display();
	       Subclass obj2= new Subclass(10);
	       obj2.display();
	  }
	}
	
//PRINTS
/*Constructor of Superclass    		// repeats cause constructor of parent always called
Constructor of Subclass
Hello
Constructor of Superclass
Constructor with arg
Hello
 */