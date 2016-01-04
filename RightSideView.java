public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) return list;
		final TreeNode END = new TreeNode(-1);

		Deque<TreeNode> queue = new LinkedList<>();
		queue.addLast(root);
		queue.addLast(END);
		boolean skip = false;

		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();

			if(!skip) {
				list.add(cur.val);
				skip = true;
			}

			if(cur == END) {
				skip = false;

				if (!queue.isEmpty()) queue.addLast(END);

			} else {
				if (cur.right != null) queue.addLast(cur.right);
				if (cur.left != null) queue.addLast(cur.left);
			}
		}


		return list;
    }
}
