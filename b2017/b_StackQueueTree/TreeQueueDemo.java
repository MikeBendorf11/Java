package b_StackQueueTree;

public class TreeQueueDemo {
	public static void main(String[] args) {
		TreeRecursion myTree = new TreeRecursion();
		int[]y = {85, 99, 92, 23, 15, 49, 83, 60, 89, 96, 1, 101};
		
		System.out.println("Order added: ");
		for (int i = 0; i < y.length; i++) {
			System.out.print(y[i] + " ");
			myTree.insert(y[i]);
		}
		
		//InOrder Recursive Printing: 
		myTree.printCall();
		//Non-recursive Printing (Exercise 9.4) 
		myTree.printCall3();
		//Graphical Version: 
		myTree.printCall2();
		//Depth calculations: (Exercise 9.5)
		myTree.depth();
	}
}
/*OUTPUT
Order added: 
85 99 92 23 15 49 83 60 89 96 1 101 

InOrder Recursive Printing: 
1 15 23 49 60 83 85 89 92 96 99 101 

(Exercise 9.4) 
Non-recursive Printing using Queues: 
85 23 99 15 49 92 101 1 83 89 96 60 

Graphical Version: 
                               85                                               
                 ┌──────────────┴────────────────────────┐                       
                23                                      99                       
        ┌────────┴─────────┐                       ┌─────┴─────┐           
       15                 49                      92          101          
  ┌─────┘                 └─────┐           ┌─────┴─────┐                             
  1                            83          89          96                             
                             ┌──┘                                                     
                            60                                                        

(Exercise 9.5)
Leaf: 1, Leafs Count: 1, Depth Sum: 3, Average Depth: 3.0
Leaf: 60, Leafs Count: 2, Depth Sum: 7, Average Depth: 3.5
Leaf: 89, Leafs Count: 3, Depth Sum: 10, Average Depth: 3.3333333333333335
Leaf: 96, Leafs Count: 4, Depth Sum: 13, Average Depth: 3.25
Leaf: 101, Leafs Count: 5, Depth Sum: 15, Average Depth: 3.0
*/