public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return BST(nums, 0, nums.length-1);
    }

    public TreeNode BST(int[] nums, int start, int end) {
        if(start > end) return null;

        int mid = (end - start)/2 + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST(nums, start, mid-1);
        root.right = BST(nums, mid+1, end);

        return root;
    }
}
