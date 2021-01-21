/**
2.2 Return Kth to Last

Implement an algorithm to find the kth to last element of a singly linked list.

To find the kth to last element, we first need to find the last element.
We can solve this question by using two iterators.
	one starting at the head of the list and the second starting at the k-th element
	When the second iterator reaches the end, the first one will be at the kth to last element.
	
O(n) time and O(1) space

	We can also jsut find the length of the list first and then iterate to the length - kth element and return it
**/
	
public class KthToLast {
	class LinkedListNode {

		int val;
		LinkedListNode next;

		public LinkedListNode(int val) {
			this.val = val;
		}
	}
	
	public static LinkedListNode find(LinkedListNode head, int k) {
		
		// invalid input
		if (k < 1) {
			return null;
		}
	
		LinkedListNode kth = head;
		LinkedListNode runner = head;
		for (int i = 0; i < k; i++) {
			// if k > length
			if (runner == null) {
				return null;
			}
			runner = runner.next;
		}
		
		while (runner != null) {
			kth = kth.next;
			runner = runner.next;
		}
		
		return kth;
		
	}
}
