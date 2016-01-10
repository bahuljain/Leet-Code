public class Solution {
    public TreeNode buildTree(int[] inorder, int[] preorder) {
        if(inorder.length == 0) return null;

        TreeNode root = build(inorder, preorder, 0, inorder.length - 1, 0);

        return root;
    }

    public TreeNode build(int[] inorder, int[] preorder, int start, int end, int pre) {
        if (post >= postorder.length) return null;

        int cur = preorder[pre];
        TreeNode root = new TreeNode(cur);

        int mid = indexOf(inorder, cur, start, end);

        if (mid - start > 0) root.left = build(inorder, preorder, start, mid - 1, pre + 1);
        if (end - mid > 0) root.right = build(inorder, preorder, mid + 1, end, mid + 1);

        return root;
    }

    public int indexOf(int[] inorder, int cur, int begin, int end) {
        for(int i = begin; i <= end; i++) {
            if (inorder[i] == cur) return i;
        }
        return -1;
    }
}
