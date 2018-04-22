package associate;

public class StringBuild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder b1 = new StringBuilder("snorkler");
		StringBuilder b2 = new StringBuilder("yoodler");
		
		String s = "hello";
		// good too but this is created at runtime
		String s2 = new String("hello"); 
		
		if(s == s2) System.out.println("== yes");
		if(s.equals(s2)) System.out.println("equals() yes");
		
		//b2.insert(1, "xxx");
		//b1.replace(3, 4, b2.substring(4)).append(b2.append(false));
		//b2.replace(3, 5, "$$$");
		
		//s.reverse(); //there is no reverse for type string
		System.out.println(b1 + "///" + b2);
		
	}

}
