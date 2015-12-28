public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (n == 0 || k == 0 || k > n)
			return result;

		result = tree(n, k, 1, new ArrayList<Integer>(), result);
		return result;
	}

	public List<List<Integer>> tree(int n, int k, int s, List<Integer> path, List<List<Integer>> result) {
		if (s <= n) {
			for (int i = s; i <= n; i++) {
				path.add(i);

				if (path.size() == k) result.add(new ArrayList<Integer>(path));

				if (path.size() <= k) result = tree(n, k, i + 1, path, result);

				path.remove(path.size() - 1);
			}
		}
		return result;
	}
}
