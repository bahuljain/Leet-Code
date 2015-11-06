public class MinDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        else {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0)
                return right + 1;
            if (right == 0)
                return left + 1;
            if(left < right)
                return left + 1;
            else
                return right + 1;
        }
    }
}
