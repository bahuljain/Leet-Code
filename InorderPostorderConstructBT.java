/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int size = inorder.length;
		if (size == 0)
			return null;

		List<Integer> post = new ArrayList<>();
		post.add(size - 1);
		post.add(size - 1);
		TreeNode root = build(inorder, postorder, post, Integer.MIN_VALUE);

		return root;
	}

	public TreeNode build(int[] inorder, int[] postorder, List<Integer> post, int parent) {
		int cur = postorder[post.get(0)];
		TreeNode root = new TreeNode(cur);
		
		if (cur != inorder[post.get(1)]) {
			// go right
			post.set(0, post.get(0) - 1);
			root.right = build(inorder, postorder, post, cur);
		}
		
		post.set(1, post.get(1) - 1);
		
		
		if (post.get(1) >= 0) {
			if (inorder[post.get(1)] != parent) {
				post.set(0, post.get(0) - 1);
				root.left = build(inorder, postorder, post, parent);
			}
		}

		return root;
	}
}
