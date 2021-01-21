/**

4.2 Minimal Tree:

Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.

A Binary tree with minimal height is one that has almost an equal number of children in both its left and right subtree and
where the left subtree elements are smaller than the root and the right subtree elements are larger than the root.

This means that the root must be the number in the middle of the array, 
the numbers to its left in the array will be in the left subtree,
the numbers to its right in the array will be in the right subtree

**/
package treesandgraphs;

public class MinimalTree {
	
	public static BinaryTreeNode minBST(int[] arr) {
		return recurse(arr, 0, arr.length - 1);
	}
	
	public static BinaryTreeNode recurse(int[] arr, int start, int end) {
		
		if (end < start) {
			return null;
		}
		
		int mid = (start + end) / 2;
		BinaryTreeNode root = new BinaryTreeNode(arr[mid]);
		
		// We need to recursively create each subtree
		// for each tree 
		root.left = recurse(arr, 0, mid - 1);
		root.right = recurse(arr, mid + 1, arr.length);
		
		return root;
	}
} 
