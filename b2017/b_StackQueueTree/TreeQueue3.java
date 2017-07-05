package b_StackQueueTree;

public class TreeQueue3 extends TreeQueue2 {
	// Class Queue of TreeNodes
	QueueNode head, tail;

	class QueueNode {
		TreeNode tNode;
		QueueNode next;
		
		public void enqueue(TreeNode tn) {
			QueueNode newTail = new QueueNode();
			newTail.tNode = tn;
			if (head == null) {
				head = newTail;
				tail = newTail;
			} else {
				tail.next = newTail;
				tail = newTail;
			}
		}

		public TreeNode dequeue() {
			if (head == null)
				throw new IllegalStateException("Can't dequeue " 
			+ "from an empty queue.");
			
			TreeNode firstItem = head.tNode;
			head = head.next;
			if (head == null) {
				tail = null;
			}
			return firstItem;
		}

		boolean isEmpty() {
			return (head == null);
		}
	}
	
	/* Non-recursive Sort Tree Printing:
	 * Graphical representation demonstrates that this method
	 * prints down through hierarchies (ex. all grandparents, all 
	 * children)  */
	void printCall3(){
		QueueNode qn = new QueueNode();
		QueueNode runner;
		
		qn.enqueue(root);
		runner=head;
		
		System.out.println("\n\nNon-recursive Printing using Queues: ");
		//isEmpty() tests for empty trees, i tests for the last leaf node
		for(int i = countNodes(root); !qn.isEmpty() && i>0; i--){
			System.out.print(runner.tNode.item + " ");
			//queue any nodes under the current node
			if(runner.tNode.left != null)
				qn.enqueue(runner.tNode.left);
			if(runner.tNode.right != null)
				qn.enqueue(runner.tNode.right);
			/* go to right node or return to left node which in queue
			 * terms is just the next item */
			runner=runner.next;
		}
	} 
}
