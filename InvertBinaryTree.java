public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        if(root.left == null && root.right != null) {
            root.left = invertTree(root.right);
            root.right = null;

            return root;
        }

        if(root.right == null && root.left != null) {
            root.right = invertTree(root.left);
            root.left = null;

            return root;
        }

        if(root.left != null && root.right != null){

            root.left = invertTree(root.left);
            root.right = invertTree(root.right);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            return root;
        }

        return root;
    }
}
