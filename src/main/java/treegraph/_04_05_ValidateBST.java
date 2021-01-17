package treegraph;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 */
class _04_05_ValidateBST {


//    BinaryTreeNode last = new BinaryTreeNode();
//    boolean isBST(BinaryTreeNode root) {
//
//        if (root == null) {
//            return true;
//        }
//
//        if (!isBST(root.left)) {
//            return false;
//        }
//        if (last != null && last.val > root.val) {
//            return false;
//        }
//        last = root;
//
//        if (!isBST(root.right)) {
//            return false;
//        }
//
//        return true;
//    }

    public static boolean isBST(BinaryTreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(BinaryTreeNode root, int min, int max) {

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
