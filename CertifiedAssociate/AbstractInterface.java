package associate;

//INTERFACE
interface I{}
class C implements I{} //extends is error
interface In extends I{} //implements: error
//interface In1 extends absolOrConcret{} // error

//ABSTRACT
abstract class AB implements I{} //extends is error
class Concrete1{}
abstract class AB2 extends Concrete1{}
abstract class Abs1{}
abstract class A2 extends Abs1{}
//interface In extends A{} // or from another abstract: error

//CONCRETE
//class Cla extends A, AB{} multiple inheritance not allowed unless:
class Cl {}
class Cla extends Cl{}
abstract class Cla2 extends Cla{} //Cl is the clearly defined super class

//USES
interface I2{ //abstract interface allowed lol, makes no difference
	//implicit final, static and public, have to initialize
	int nI2 = 2; 
	static void myMethod() {
	}
}

abstract class Abs2 implements I2{
	int nAbs2; 
	abstract void absVoid(); //only declares
}
class C2 extends Abs2{
	@Override //so eclipse considers it
	void absVoid() {// has to implement 
	}
	//has to as well, but Abs2 above didn't
	public void myMethod() { } 
}


public class AbstractInterface {
}
