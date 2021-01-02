package linkedlist;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
class _02_02_ReturnKthToLast {

    LinkedListNode kthToLast(LinkedListNode head, int k) {

        if (k < 1) {
            return null;
        }
        LinkedListNode dummyHead = new LinkedListNode(0);
        dummyHead.next = head;
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        head = dummyHead.next;

        if (k > length) {
            return null;
        }
        for (int i = 1; i <= length - k; i++) {
            head = head.next;
        }

        return head;
    }
}
