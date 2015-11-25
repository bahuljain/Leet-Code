public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // if left subtree of root exists
        // move the (right subtree of the root) to the (right of the (rightmost node in the (left subtree of the root).
        // now make the left subtree of the root as its right subtree.
        // set the left child of root as null

        if(root == null) return;

        if(root.left != null) {
            TreeNode rightMost = rightMostNode(root.left);
            rightMost.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        flatten(root.right);
    }

    public TreeNode rightMostNode(TreeNode root) {
        if(root.right == null) return root;
        return rightMostNode(root.right);
    }
}
