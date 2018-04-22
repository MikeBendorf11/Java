package associate;

interface II{int i = 0;}
class AA implements II{int a;}
class BB extends AA{int b;}

public class Inheritance2 {
	
	public static void main(String[] args) {
		II i =  new II() {}; 
		AA a = new AA();
		BB b = new BB();
		
		II i2 = new AA(); ((AA)i2).a = 2;
		AA a2 = new BB(); a2.a = 0; ((BB)a2).b = 1; 
		BB b2 = new BB(); b2.a = b2.b + b2.i;
		
		i = a = b;
		//i = a; 
		//a = new B();
		
		//b = (B)a; //fails if we remove line a = b
		a = (AA)i;
		
		a = (AA)b;
		i = (AA)b;
		
		//a = (I)b;
		//System.out.println(associate.Initializers.ID2);

		
		
		
		

		
	}	
}
