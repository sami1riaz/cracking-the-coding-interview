package treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 4.3 List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
/// Need to fix Unit tests ////

class _04_03_ListOfDepths {

    //time o(N) space o(N)
    List<LinkedList<BinaryTreeNode>> create(BinaryTreeNode root) {

        List<LinkedList<BinaryTreeNode>> listOfDepths = new ArrayList<>();

        // This queue will hold the nodes that still need to be visited
        // i.e.
        LinkedList<BinaryTreeNode> currents = new LinkedList<>();

        if (root != null) {
            currents.add(root);
        }

        while(currents.size() > 0){
            // Add the entire Linked List stored in current var to listOfDepths;
            listOfDepths.add(currents);
            // store previous level's nodes.
            LinkedList<BinaryTreeNode> parents = currents;

            // Empty currents List
            currents = new LinkedList<BinaryTreeNode>();

            for (BinaryTreeNode node : parents) {
                if (node.left != null){
                    currents.add(node.left);
                }
                if (node.right != null){
                    currents.add(node.right);
                }
            }
        }

        return listOfDepths;
    }

}
