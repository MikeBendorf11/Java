/*(EXERCISE 9.5)
 * Calculates the depth average of a binary tree
 * The output will print the progress of calculations 
 * every time a leaf node is found 
 * 
 * Every binary tree recursion exercise in this chapter 
 * involved calling `method(node.right)` and 
 * `method(node.left)`. This was the only way of
 *  navigating through every node*/

package b_StackQueueTree;

class TreeRecursion extends TreeQueue3 {
	/* depth total, Max, Sum and n# of leafs */
	int dpT, dpM, leafs;

	/* Executes dptotal and initializes vars.
	 * Could not have done this from dptotal() itself */
	void depth() {
		System.out.println("\n(Exercise 9.5)");
		dpT = dpM = leafs = 0;
		dptotal(root, 0);
	}

	/* Returns the largest depth so far */
	int dpmax(int depth) {
		return (depth > dpM) ? depth : dpM;	
	}

	/* Sending the dpS(sum) back to the recursion process
	 * was the only way of skipping adding to dpS unnecessarily
	 * when switching form left to right nodes*/
	void dptotal(TreeNode root, int dpS) {

		if (root != null) {
			dpS++;
			dptotal(root.left, dpS);
			dptotal(root.right, dpS);

			/* Remember no node will be counted twice because 
			 * recursion continues from leftover pending process*/
			if (root.left == null && root.right == null) {
				dpS--;
				leafs++;
				dpT = dpT + dpS;
				dpM = dpmax(dpS); // store the max so far

				System.out.print("Leaf: " + root.item);
				System.out.print(", Leafs Count: " + leafs);
				System.out.print(", Depth Sum: " + dpT);
				System.out.print(", Average Depth: " 
									+ (double) dpT / leafs);
				System.out.println();

			}
		}
	}
}
