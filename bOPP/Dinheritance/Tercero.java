package Dinheritance;

public class Tercero extends Segundo {
	String diceChico = null;
	/*chico is overriding mayor and medio methods*/
    void mayorMethod() {
        System.out.println(
        		"I also override mayorMethod");
    }
    void medianoMethod() {
        System.out.println(
        		"I override medioMethod");
    }
    void chicoMethod() {
        System.out.println(
        		"Chico says: I implement all of us: " + diceMayor 
        		+ diceMediano + diceChico);
    }

}
