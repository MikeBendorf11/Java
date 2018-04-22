package associate;

//instantiate this classes or call its fields from another file's main
class TCS{
	static String ID = "OOO";
	{System.out.println("in TCS");}
}

public class Initializers extends TCS{
	static String ID2 = "PPP";
	static{System.out.println("in TestClass");}
}
