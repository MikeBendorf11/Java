package b_StackQueueTree;

public class TreeQueueDemo {
	public static void main(String[] args) {
		TreeQueue3 myTree = new TreeQueue3();
		int[]y = {85, 99, 92, 23, 15, 49, 83, 60, 89, 96};
		
		System.out.println("Order added: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(y[i] + " ");
			myTree.insert(y[i]);
		}
		
		//InOrder Recursive Printing: 
		myTree.printCall();
		//Graphical Version: 
		myTree.printCall2();
		//Queue Non-recursive Printing
		myTree.printCall3();
	}
}
