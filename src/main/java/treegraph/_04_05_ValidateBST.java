package treegraph;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 */
class _04_05_ValidateBST {


    BinaryTreeNode last = new BinaryTreeNode();
    boolean isBST(BinaryTreeNode root) {

        if (root == null) {
            return true;
        }

        if (!isBST(root.left)) {
            return false;
        }
        if (last != null && last.val > root.val) {
            return false;
        }
        last = root;

        if (!isBST(root.right)) {
            return false;
        }

        return true;
    }


}
