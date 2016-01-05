public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		res.add(subset);

		if (nums.length == 0)
			return res;

		Arrays.sort(nums);

		List<List<Integer>> prev = new ArrayList<>();
		prev.add(subset);

		subsets(nums, 0, res, prev);

		return res;
	}

	public void subsets(int[] nums, int n, List<List<Integer>> res, List<List<Integer>> prev) {
		int curNum = Integer.MIN_VALUE;
		for (int j = n; j < nums.length; j++) {
			if (curNum != nums[j]) {
				for (int i = 0; i < prev.size(); i++) {
					prev.get(i).add(nums[j]);
					res.add(new ArrayList<>(prev.get(i)));
				}

				subsets(nums, j + 1, res, prev);

				for (int i = 0; i < prev.size(); i++) {
					prev.get(i).remove(prev.get(i).size() - 1);
				}

				curNum = nums[j];
			}
		}
	}
}
