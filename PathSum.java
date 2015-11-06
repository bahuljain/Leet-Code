public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        } else {
            return check(root, sum);
        }

    }

    public boolean check(TreeNode root, int sum) {
        if(root.left == null && root.right == null){
            sum = sum - root.val;
            if(sum == 0)
                return true;
            else
                return false;
        } else {
            if(root.left == null) {
                sum = sum - root.val;
                return check(root.right, sum);
            } else {
                return check(root.left, sum);
            }
        }
    }
}
