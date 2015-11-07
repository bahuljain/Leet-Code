public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        //invert binary tree and check if exactly equal
        if(root != null) {
            TreeNode rootInvert = new TreeNode(root.val);
            rootInvert = createInvertedTree(rootInvert, root);
            return isSameTree(root, rootInvert);
        } else {
            return true;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else {
            if((p == null && q != null) || (p != null && q == null) || p.val != q.val)
                return false;
            else
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }

    public TreeNode createInvertedTree(TreeNode invertRoot, TreeNode root) {
        if(root == null)
            return null;

        if(root.left == null && root.right != null) {
            invertRoot.left = new TreeNode(root.right.val);
            invertRoot.left = createInvertedTree(invertRoot.left, root.right);
            invertRoot.right = null;

        } else if(root.right == null && root.left != null) {
            invertRoot.right = new TreeNode(root.left.val);
            invertRoot.right = createInvertedTree(invertRoot.right, root.left);
            invertRoot.left = null;

        } else if(root.left != null && root.right != null){
            invertRoot.left = new TreeNode(root.right.val);
            invertRoot.right = new TreeNode(root.left.val);

            invertRoot.right = createInvertedTree(invertRoot.right, root.left);
            invertRoot.left = createInvertedTree(invertRoot.left, root.right);
        }
        return invertRoot;
    }

    // Another sweet way of doing this would be to do a binary tree level order
    // trversal and storing nodes of every level in a linked list. Then we check
    // if every list is a palindrome or not. If yes then the tree is symmetric
    // else not. https://github.com/tg123/leetcode/tree/gh-pages/symmetric-tree

}
