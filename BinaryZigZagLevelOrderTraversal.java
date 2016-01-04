public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> trav = new ArrayList<>();

		if (root == null) return trav;

		final TreeNode END = new TreeNode(-1);

		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(END);

		List<Integer> level = new ArrayList<>();
		boolean dir = true; // dir == true means forward direction else backward direction

		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();

			if(cur == END) {
				trav.add(new ArrayList<Integer>(level));
				level.clear();
				dir = !dir;

				if (!queue.isEmpty()) queue.add(END);

			} else {
				if (dir) {
					level.add(cur.val);
				} else {
					level.add(0, cur.val);
				}

				if (cur.left != null) queue.add(cur.left);
				if (cur.right != null) queue.add(cur.right);
			}
		}

		return trav;
	}
}
