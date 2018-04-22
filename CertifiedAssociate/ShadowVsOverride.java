package associate;

class uno{
	int num =1;
	void ins() {System.out.println("uno: ins()");}
	static void stc(){System.out.println("uno: stc()");}
}
	
class dos extends uno{
	int num =2;
	void ins() {System.out.println("dos: ins()");}
}
public class ShadowVsOverride {
static void main(String[]args) {
	uno unoObj = new uno();
	uno unoObj2 = new dos();
	dos dosObj = new dos();
	System.out.println("unoObj.num = " + unoObj.num);
	unoObj.ins();
	uno.stc();
	System.out.println("((uno)unoObj2).num = " + ((uno)unoObj2).num);
	
}
	


}

