package associate;

class Parent{
	//checked vs unchecked???
	public void mth() throws Throwable //it might throw or not
	{System.out.println("P");}
}
public class Exceptions1 extends Parent{
	public void mth() 
	{System.out.println("C");}

public static void main(String[] args) {
	try {}

	catch(RuntimeException e) {}
	catch(Exception ec) {} //AssertionError works too
	
	try { 
		Parent P = new Exceptions1();
		P.mth();
	} catch (Throwable t) {
		t.printStackTrace();
		
	}
	/////////////////// valid too ///////////////////////
	// if not caught then executes finally and throws/crashes
	try {}
	finally {
		//throw new Exception(); 
	}
	
		
	}	
	
}
