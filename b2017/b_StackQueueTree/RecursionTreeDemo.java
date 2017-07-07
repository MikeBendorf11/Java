package b_StackQueueTree;

import java.util.Random;

public class RecursionTreeDemo {

	public static void main(String[] args) {
		RecursionTree2 myTree = new RecursionTree2();
		int[] y = { 85, 99, 92, 23, 15, 49, 83, 60, 89, 96 };
		for (int i = 0; i < y.length; i++) {
			myTree.insert(y[i]);
		}
		myTree.depth();
		System.out.print("\n\n");
		myTree.print2(myTree.root);
 
	}
}
/*
Leaf: 15, Leafs Count: 1, Depth Sum: 2, Average Depth: 2.0
Leaf: 60, Leafs Count: 2, Depth Sum: 6, Average Depth: 3.0
Leaf: 89, Leafs Count: 3, Depth Sum: 9, Average Depth: 3.0
Leaf: 96, Leafs Count: 4, Depth Sum: 12, Average Depth: 3.0


                               85                               
                ┌───────────────┴───────────────┐               
               23                              99               
        ┌───────┴───────┐               ┌───────┘               
       15              49              92                       
                        └───┐       ┌───┴───┐                   
                           83      89      96                   
                          ┌─┘                                   
                         60                                     
  	*/