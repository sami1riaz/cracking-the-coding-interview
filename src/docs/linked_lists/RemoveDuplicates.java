/**
2.1 Remove Duplicates

Remove Dups!
Write code to remove duplicates from an unsorted linked list.


To keep track of duplicates, we can use a HashSet.
Whenever we see an element that is not in the HashSet, we add it to the set, otherwise we remove it from the List.
We will need to 

This would take us O(n) time as we will always need to iterate through the entire list,
and O(n) space as in the worst case, there will be no duplicates and the set will be the same size as the list.


How can we do this without a temporary buffer?
	The most obvious way to do this witout a buffer would be to use two iterators.
	For each element in the List, we would have to compare it to every other element to check if it is a duplicate.
	O(n^2) time and O(1) space
	
	We could also sort the list and then check adjacent elements to see if they are duplicates. O(nlogn) time and O(1) space

**/

package linked_lists;

import java.util.HashSet;

public class RemoveDuplicates {
	
	class LinkedListNode {

		int val;
		LinkedListNode next;

		public LinkedListNode(int val) {
			this.val = val;
		}
	}
	
	public LinkedListNode removeDups(LinkedListNode head) {
		
		HashSet<Integer> dups = new HashSet<>();
		
		LinkedListNode dummy = new LinkedListNode(0);
		dummy.next = head;
		
		LinkedListNode prev = null;
		
		while ( head != null) {
			
			if (dups.contains(head.val)) {
				prev.next = head.next;
			} else {
				dups.add(head.val);
				prev = head;
			}
			
			head = head.next;
		}
		return dummy.next;
	}

	// tested in _02_01_RemoveDupsTest
}
