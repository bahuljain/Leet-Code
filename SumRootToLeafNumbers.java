public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        // easy should not be a problem
        return sums(root, 0);

    }

    public int sums(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum*10 + root.val;
        int newSum = sums(root.left, sum) + sums(root.right, sum);
        return (newSum == 0) ? sum : newSum;
    }
}
