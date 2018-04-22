package associate;

public class WrapperClasses  {
	public static void main(String[] args) {
		long l = 123;
		int i = 456;
		Long L = 999999999999999999L; //had to add l 
		Integer I = 789;
		//l = i;
		//i = (int)l;
		//I = i;
		//i = I; 
		int a = new Integer(0);
		Integer i2 = new Integer(0);
		
		new WrapperClasses().test((Integer)a);
	}
	void test(Integer I) { System.out.println("I");	}
	void test(int... i) { System.out.println("i range");	}
	void test(int i) { System.out.println("i");	}
	void test(Long L) { System.out.println("L");	}
	void test(long l) { System.out.println("l");	}
}
