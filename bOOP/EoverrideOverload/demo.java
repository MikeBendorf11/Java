package EoverrideOverload;

 class demo {

	public static void main(String[] args) {
		child tu = new child();
		
		//child overrides + embedded parent method
		tu.metodo1(7, " siete ");
		//child overrides (replaces parent method)
		tu.metodo1();
		//child overloads (new implementation)
		tu.metodo1("algo ", 666, tu.a);
		
		parent yo = new parent();
		//regular parent method
		yo.metodo1(5, " cinco ");
		//regular parent method
		yo.metodo1();
		System.out.println(yo.a);
		
		/*PRINTS:
		parent 7  siete 
		child 
		Child overrides
		Child overloads algo  this: 666 super: 10
		static s: 333

		parent 5  cinco 
		vacio parent 0
		0
		*/
	}

}
