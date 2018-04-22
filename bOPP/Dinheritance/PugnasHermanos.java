package Dinheritance;

public class PugnasHermanos {

	public static void main(String[] args) {
		Primero anacleto = new Primero();
		Segundo benigno = new Segundo();
		Tercero robin = new Tercero();

		anacleto.diceMayor = "Yo tengo peladas";
		/*El Mayor ya no tiene el metodo medio ni chico
		 * anacleto.diceMediano = ERROR */
		
		benigno.diceMayor = "Antes era un cobarde";
		benigno.diceMediano = "Pero yo soy el tuco";
		/* no access to chico vars or methods
		 * benigno.diceChico =  ERROR */
		
		robin.diceMayor = "Yo tengo peladas, ";
		robin.diceMediano = "musculos, ";
		robin.diceChico = "y cabeza";

		anacleto.mayorMethod();
		//avail only through Primero class
		//anacleto.secretos(); 
		
		benigno.mayorMethod();
		benigno.medianoMethod();
		
		robin.chicoMethod();
		robin.mayorMethod();
		robin.medianoMethod();
		/*
		El Mayor decia: Yo tengo peladas
		Mayor secretos revelados...
		El Mayor decia: Antes era un cobarde
		Mayor secretos revelados...
		El Mediano decia: Pero yo soy el tuco
		Chico says: I implement all of us: Yo tengo peladas, 
		musculos, y cabeza
		I override mayorMethod
		I override medioMethod
		*/
	}
}

/*The objective of extends(which belongs to inheritance 
 * properties) is to add or override features to the parent
 * class data or methods. 
 * This is a grandparent, parent, child relationship not to
 * be confused with nested/enclosed/inner, enclosing/outter
 * classes*/
