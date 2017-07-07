package b_StackQueueTree;


public class RecursionTree1 {
TreeNode root;
	
	class TreeNode {
		int item;
		TreeNode left;
		TreeNode right;

		TreeNode(int number) {
			item = number;
		}
		TreeNode getLeft() {
			return left;
		}

		TreeNode getRight() {
			return right;
		}

		String getText() {
			return String.valueOf(item);
		}
	}
	
	/* This is a binary sort tree implementation.*/
	void insert(int newItem) {
		if (root == null) {
			root = new TreeNode(newItem);
			return;
		}
		TreeNode runner;
		runner = root;
		while (true) {
			if (newItem < runner.item) {

				if (runner.left == null) {
					runner.left = new TreeNode(newItem);
					return;
				} else
					runner = runner.left;
			} else {
				if (runner.right == null) {
					runner.right = new TreeNode(newItem);
					return;
				} else
					runner = runner.right;
			}
		}
	}
	
	
	boolean contains(TreeNode root, int item) {
		if (root == null) {
			return false;
		} else if (item == root.item) {
			return true;
		} else if (item < root.item) {
			return contains(root.left, item);
		} else {
			return contains(root.right, item);
		}
	}
	
	int countNodes(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int leftCount = countNodes(node.left);
			int rightCount = countNodes(node.right);
			return 1 + leftCount + rightCount;
		}
	}


	/* To be used from main so main doesn't have to access root */
	void printCall() {
		System.out.println("\n\nInOrder Recursive Printing: ");
		print(root);
	}
	
	//inOrder recursive method
	void print(TreeNode node) {
		if (node != null) {
			print(node.left);
			System.out.print(node.item + " ");
			print(node.right);
		}
	}
	
}
