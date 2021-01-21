package treesandgraphs;

/**
 * 4.3 List of Depths
 * 
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 
 
 To solve this question, we need to keep track of the depth. As we traverse the tree, we keep track of the depth and
 use that depth to add the node in the correct place of the list.
 
 We will need to create a NodeDepthPair class for this.
 
 
 public class ListOfDepths {
	 
	 
	 public static List<LinkedList<Node>> listDepths(BinaryTreeNode root) {
		 
		 List<List<Node>> listOfDepths = new ArrayList<>();
		 
		 if (root == null) return listOfDepths;
		 
		 Deque<NodeDepthPair> queue = new ArrayDeque<>();
		 List<BinaryTreeNode> level = new LinkedList<>(); 
		 
		 queue.push(new NodeDepthPair(root,0));
		 
		 
		 while(!queue.isEmpty) {
			 NodeDepthPair curr = queue.poll();
			 listOfDepths.add(curr.depth, curr.node);
			 
			 queue.push(new NodeDepthPair(curr.left, curr.depth + 1));
			 queue.push(new NodeDepthPair(curr.right, curr.depth + 1));
			 
			 
		 }
		 
		 return listDepths;
	 }
 }

This could have worked with a NodeDepthPair class if we didn't need to return a linked list of nodes at each level.
I missed that detail.
Since we need linked lists, we will need to create the linked list first and then add the entire list at each level.
* 
* 
* Time Complexity: O(n) as we traverse the entire tree (BFS) and O(n) space for the list that is returned (it contains all n nodes of the tree)

**/

import java.util.List.*;

public class ListOfDepths {
	
	public static List<LinkedList<Node>> listDepths(BinaryTreeNode root) {
		
		
		List<List<BinaryTreeNode>> listOfDepths = new ArrayList<>();
		
		if (root == null) return listOfDepths;
		
		List<BinaryTreeNode> visiting = new LinkedList<>();
		visiting.add(root)
		
		// While we have not reached level after leaves
		while (visiting.size() > 0 ) {
			listOfDepths.add(root);
			// Since the level has been added to listOfDepths, we have visited these nodes
			List<BinaryTreeNode> visited = visiting;
			
			// create new visiting linked list
			visiting = new LinkedList<>();
			// update visiting linked list with nodes of next level
			for (BinaryTreeNode node : visited) {
				if (node.left != null){
                    visiting.add(node.left);
                }
                if (node.right != null){
                    visiting.add(node.right);
                }
			}
			
		}
		return listOfDepths;
		
	}
}
	
