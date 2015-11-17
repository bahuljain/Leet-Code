/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return (root == null) ? false : hasSum(root, sum);
    }

    public boolean hasSum(TreeNode root, int sum) {
        sum = sum - root.val;

        if(root.right == null && root.left == null) {
            return (sum == 0) ? true : false;
        } else {
            if(root.right == null && root.left != null) {
                return hasSum(root.left, sum);
            } else if(root.right != null && root.left == null) {
                return hasSum(root.right, sum);
            } else {
                return hasSum(root.right, sum) || hasSum(root.left, sum);
            }

        }
    }
}
