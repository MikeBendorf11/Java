package EoverrideOverload;

class parent {
	int a;
	static int s = 333;
	
	 void metodo1(int numero, String texto){
		System.out.println("parent " 
	 + numero + " " + texto);
	}
	void metodo1(){
		System.out.println("vacio parent " + a);
	}
		
	
}
