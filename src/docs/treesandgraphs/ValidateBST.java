package treesandgraphs;

/**
4.5 Validate BST


 * Implement a function to check if a binary tree is a binary search tree.
 
 
 One main property of a BST is that it can be converted into a sorted array.
 If we traverse through the tree (from left most child to root to right most child i.e. in order traversal)
 and add the elements to an array, we get a sorted array.

For this question, we don't have to go so far as to convert it into an array, we simply do an in-order traversal and if the elements are in sorted order,
we have a BST!

This takes O(n) time as we are going through each node and O(log(n)) as recursive calls take space on the stack
**/

/**
public class ValidateBST {
	
	private static BinaryTreeNode prev = new BinaryTreeNode();
	
	public static boolean isBST(BinaryTreeNode root) {
		
		//base case
		if (root == null) return true;
		
		// Check left node first
		if (!isBST(root.left)) return false;
		
		// if previous nodes val was larger than currents
		if (prev != null && prev.val > root.val ) {
				return false;
		}
		
		if (!isBST(root.right)) return false;
		
		return true;
	}
}
**/

/**
Another way to solve this question is to check if each node in the tree satisfies the property of a BST node.

To do this, we need to keep track of the possible max and min values of that node. 
Remember that in a BST, all nodes to the left of a node must be smaller than it and vice versa.
So, if we're traversing to the left sub-tree, we will need to update the max val and 
if we're traversing to the right sub-tree, we will need to update the min value.
(we don't need to update the min val in the left sub tree as it will always be Integer.MIN_VAL or null. Same applies for right sub-tree)

This algorithm also has the same time and space complextiy as above
**/

public class ValidateBST {
	
	
	public boolean isBST(BinaryTreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isBST(BinaryTreeNode root, int min, int max) {
		 
		//base case
		if (root == null) return true;
		
		
		// if min is not MIN_VAL, then we are in the right side of the sub-tree and vice-versa
		if ( (min != Integer.MIN_VALUE && min > root.val) ||
				(max != Integer.MIN_VALUE && max <= root.val) )
				return false;
		
		if (!isBST(root.left, Integer.MIN_VALUE, root.val) ||
				!isBST(root.right, root.val, Integer.MAX_VALUE) ) {
					return false;
		}
		return true;
	}
}

