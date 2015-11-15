public class LowestCommonAncestor {
    // i think i did this for a binary tree for a binary search tree should be
    // easier
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //for different combinations of left and right
        if(left != null &&  right != null)
            return root;
        if(left != null && right == null)
            return left;
        if(left == null && right != null)
            return right;
        else
            return null;
    }

    // this ones for a binary search tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // make sure p < q
        if(p.val > q.val) return lowestCommonAncestor(root, q, p);

        // find p <= root <= q
        while(!(p.val <= root.val && root.val <= q.val)){

            if(root.val > q.val){
                root = root.left;
            } else { // root.val < p.val
                root = root.right;
            }

        }

        return root;
    }
}
