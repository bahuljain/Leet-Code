/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        if (root != null) cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (cur != null || !stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        cur = stack.pop();
        TreeNode temp = cur;
        cur = cur.right;
        return temp.val;
    }

    // public void inorder(TreeNode root) {
    //     if (root == null) return null;

    //     TreeNode cur = root;

    //     while(!stack.isEmpty() || cur != null) {
    //         if(cur == null) {
    //             cur = stack.pop();
    //             // print cur
    //             cur = cur.right;
    //         } else {
    //             stack.push(cur);
    //             cur = cur.left;
    //         }
    //     }
    // }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
