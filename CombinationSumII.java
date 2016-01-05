public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();

		if (candidates.length == 0)
			return res;

		Arrays.sort(candidates);

		combine(candidates, target, 0, new ArrayList<Integer>(), 0, res);
		return res;
	}

	public void combine(int[] candidates, int target, int sum, List<Integer> sol, int s, List<List<Integer>> res) {
		if (s < candidates.length) {
			int entered = 0;
			for (int i = s; i < candidates.length; i++) {
				if (entered != candidates[i]) {
					sol.add(candidates[i]);
					sum += candidates[i];
					entered = candidates[i];

					if (sum == target) {
						res.add(new ArrayList<Integer>(sol));
					}

					if (sum < target) {
						combine(candidates, target, sum, sol, i + 1, res);
					}

					sol.remove(sol.size() - 1);
					sum -= candidates[i];
				}
			}
		}
	}
}
