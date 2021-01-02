package linkedlist;

import java.util.HashSet;

/**
 * Remove Dups!
 * Write code to remove duplicates from an unsorted linked list.
 */
class _02_01_RemoveDups {

    LinkedListNode removeDups(LinkedListNode head) {

        // to keep track of head node cuz we need to return it
        LinkedListNode dummyHead = new LinkedListNode(0);
        dummyHead.next = head;

        HashSet<Integer> unique = new HashSet<>();

        // we need a prev node because to remove the dup
        // we need to change the pointer of the prev node to the one the dup is pointing to
        LinkedListNode prev = null;

        while (head != null){
            if (unique.contains(head.val)) {
                prev.next = head.next;
            } else {
                unique.add(head.val);
                prev = head;
            }
            head = head.next;
        }

        return dummyHead.next;

    }
}
