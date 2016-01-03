public class Solution {
	// Very similar to Combinations problem, except that now there is a addition
	// sum constraint.
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		if (n == 0 || k == 0)
			return result;

		result = tree(9, k, 1, new ArrayList<Integer>(), result, n, 0);
		return result;
	}

	public List<List<Integer>> tree(int n, int k, int s, List<Integer> path, List<List<Integer>> result, int sum, int pathSum) {
		if (s <= n) {
			for (int i = s; i <= n; i++) {
				path.add(i);
				pathSum += i;

				// here the sum constraint is added
				if (path.size() == k && pathSum == sum)
					result.add(new ArrayList<Integer>(path));

				// and here as well. Thats all
				if (path.size() <= k && pathSum < sum)
					result = tree(n, k, i + 1, path, result, sum, pathSum);

				path.remove(path.size() - 1);
				pathSum -= i;
			}
		}
		return result;
	}
}
