package EoverrideOverload;

class child extends parent{
	int b = 10;

	void metodo1(int numero, String texto){
		// calling super's method
		super.metodo1(numero, texto);
		//and doing smth else
		System.out.println("child ");
	}
	
	//Overridden: has the same signature
	void metodo1(){
		System.out.println("Child overrides");
	}
	
	//Overloaded: has a different signature
	void metodo1(String algo, int b, int a){
		//using variable from this class
		this.b = b;
		
		/*assigning val to parent var just while this
		 * method is in use*/
		super.a = 10;
		System.out.println("Child overloads " + algo 
		+ " this: " + b + " super: "+ super.a 
		+ "\nstatic s: " + parent.s + "\n");
	}
}
