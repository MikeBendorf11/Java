package associate;


class Aaa{
	static void mm() {System.out.println("Aaa(mm)");}
	static void mm2() {System.out.println("Aaa(m2)");}
	void dd() {System.out.println("Aaa(dd)");}
}

public class StaticVsInstanceMeth extends Aaa {
	static void mm() {System.out.println("SVI(mm)");}
	void dd() {System.out.println("SVI(dd)");}
	
	 public static void main(String[] args){
	  Aaa.mm();
	  StaticVsInstanceMeth.mm();
	  StaticVsInstanceMeth.mm2();
	  System.out.println("----------------");
	  Aaa a = new StaticVsInstanceMeth();
	  a.mm();
	  ((StaticVsInstanceMeth)a).mm();
	  a.dd();
	  System.out.println("----------------");
	  ((StaticVsInstanceMeth)a).dd();
	  Aaa a2 = new Aaa();
	  a2.dd();
	  
	}
}

