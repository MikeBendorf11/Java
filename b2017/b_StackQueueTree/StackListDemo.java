package b_StackQueueTree;
	
	/*EXERCISE 9.3: REVERSING A LIST OF INT*/

public class StackListDemo {
	public static void main(String[] args) {

		/* Implemented as a Stack*/
		StackList list = new StackList();
		
		System.out.println("\nOriginal Stack:");
		/* Items pile up from #10
		 * #1 will be the top item in the stack */
		for (int i = 10; i > 0; i--) 
			list.insert(i);
		list.print();
		
		/* #10 is now is at the top */
		System.out.println("\nReversed Stack:");
		list.reverseList();
		list.print();
	}
}
	/*-----------------------
		PRINTS:
		Original Stack:
		1 2 3 4 5 6 7 8 9 10 
		Reversed Stack:
		10 9 8 7 6 5 4 3 2 1 
	 ------------------------*/