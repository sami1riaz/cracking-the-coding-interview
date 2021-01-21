/**

Node Data Structure

**/

package treesandgraphs;

class Node {
    int val;
    Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
    
    Node(int val) {
        this.val = val;
    }

	public Node() {}
    
}
