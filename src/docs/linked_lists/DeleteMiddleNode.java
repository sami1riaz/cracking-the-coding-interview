/**

2.3 Delete Middle Node

Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) 
of a singly linked list, given only access to that node. 

EXAMPLE 
	Input:the node c from the linked list a->b->c->d->e->f
	Result: nothing is returned, but the new linked list looks like a ->b->d->e->f


When trying to delete a linked list node, we do not actually delete the node.
A common way to delete a node is to swap its value with it's next node's value and point it to next.next:

1->2->3->4. Delete 3

1->2->4 4 
      |   ^
      |___|

**/
package linked_lists;
       
public class DeleteMiddleNode {
	
	class LinkedListNode {
		
		int val;
		LinkedListNode next;
		
		public LinkedListNode(int val, LinkedListNode next) {
			this.val = val;
			this.next = next;
		}
		
		public LinkedListNode(int val) {
			this.val = val;
		}
	}
	
	public void deleteMid(LinkedListNode mid) {
		
		// it's not actually possible to check that the node is the head with the information provided to us
		// We will have to assume that the node is not the head of the list
		if (mid == null || mid.next == null) {
			return;
		}
		
		mid.val = mid.next.val;
		mid.next = mid.next.next;
	}
		 
}
