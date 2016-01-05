public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        List<Integer> path = new ArrayList<>();

        paths(root, 0, sum, res, path);

        return res;
    }

    public void paths(TreeNode root, int pathSum, int sum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        pathSum += root.val;

        if (root.left == null && root.right == null) {
            if (pathSum == sum) res.add(new ArrayList<>(path));
        } else {
            if (root.left != null) paths(root.left, pathSum, sum, res, path);
            if (root.right != null) paths(root.right, pathSum, sum, res, path);
        }

        path.remove(path.size() - 1);
        pathSum -= root.val;
    }
}
