package b_StackQueueTree;

import java.util.ArrayList;

public class StackList {

	class ListNode {
		int item;
		ListNode next;
	}

	ListNode head;

	public void insert(int insertItem) {
		ListNode newNode;
		newNode = new ListNode();
		newNode.item = insertItem;

		if (head == null) {
			head = newNode;
		} else {
			//the one that was previously pointed
			newNode.next = head; 
			head = newNode;
		}
	}
	
	//Prints from the top of the stack
	public void print() {
		ListNode runner;
		for (runner = head; runner != null; runner = runner.next)
			System.out.print(runner.item + " ");
	}
	
	public void reverseList() {
		ListNode runner;
		ArrayList<Integer> arl = new ArrayList<Integer>();

		//Copy stack to an array. Loop starts from top
		for (runner = head; runner != null; runner = runner.next) 
			arl.add(runner.item);
		
		int count = arl.size()-1;
		
		/* Starts from the top of the stack again 
		 * but array is copied from last instead*/
		for (runner = head; runner != null; 
				runner = runner.next, count--)
			runner.item = arl.get(count);
	}
}
