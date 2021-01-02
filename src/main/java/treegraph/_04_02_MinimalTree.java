package treegraph;

/**
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 */
class _04_02_MinimalTree {

    BinaryTreeNode buildMinimalTree(int[] vals) {
        return buildMinimalTree(vals, 0, vals.length - 1);
    }
    BinaryTreeNode buildMinimalTree(int[] subtree, int start, int end) {
        // Node does not have subtree (i.e. leaf node)
        if (end < start) {
            return null;
        }

        // Root is always the middle element in a particular sub-tree
        // Keep in mind that Root here is actually the index in the array.
        int root = (start + end) / 2;

        BinaryTreeNode current = new BinaryTreeNode(subtree[root]);

        // left side of root in array will be the left subtree so we need to repeat the process
        // of finding the root of this new subtree. Same with right side of the root
        current.left = buildMinimalTree(subtree, 0, root - 1);
        current.right = buildMinimalTree(subtree, root + 1, end);

        // Add current node to the tree
        return current;
    }


}
