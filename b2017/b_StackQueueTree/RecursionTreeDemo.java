package b_StackQueueTree;

import java.util.Random;

public class RecursionTreeDemo {

    public static void main(String[] args) {
        RecursionTree2 myTree = new RecursionTree2();
        int[]y = {85, 99, 92, 23, 15, 49, 83, 60, 89, 96};
        for (int i = 0; i < 10; i++) {
			myTree.insert(y[i]);
		}
        //myTree.counter(myTree.root);
        myTree.counterD(myTree.root); 
        /*
        Random rdn = new Random();
        int x;
        
        for(int i=0; i<1023; i++){
            x = rdn.nextInt(10000) + 1;
            myTree.insert(x);
        }
        
        myTree.countLeaf(myTree.root); 
		*/
    }

}

/*The depth of a node in a binary tree is the length of the path from the root of the tree to that node.
In an approximately balanced tree with 1023 nodes, the average depth of all the leaves should be not too much bigger than 9.
To do this, you will need three recursive subroutines: 
one to count the leaves, 
one to find the sum of the depths of all the leaves, and 
one to find the maximum depth. 
The latter two subroutines should have an int-valued parameter, depth, that tells how deep in the tree you've gone. When you call this routine from the main program, the depth parameter is 0; when you call the routine recursively, the parameter increases by 1.
*/

