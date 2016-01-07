public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		// start with first element -> size = 1
		// insert the next element at all positions in all of permutations of size n-1

		List<List<Integer>> perm = new LinkedList<>();
		if (nums.length <= 0) return perm;

		List<Integer> first = new LinkedList<>();
		first.add(nums[0]);
		perm.add(first);

		// this loop to iterate over all the nums
		for (int i = 1; i < nums.length; i++){

			// this loop to iterate over all the lists of size n-1
			int iter = perm.size();
			for (int j = 0; j < iter; j++ ) {

				// this loop to add the next element at all positions in cur list
				List<Integer> cur = perm.remove(0);
				for (int k = 0; k < i+1; k++) {
					List<Integer> temp = new LinkedList<>(cur);
					temp.add(k, nums[i]);
					perm.add(temp);
				}
			}
		}

		System.out.println(perm);

		return perm;
	}

}
