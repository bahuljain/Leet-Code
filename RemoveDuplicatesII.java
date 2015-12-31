public class RemoveDuplicatesII {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;

		int count = 1; boolean skip = false;

		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != nums[count-1]) {
				nums[count++] = nums[i];
				skip = false;
			} else {
				if (skip == false) {
					nums[count++] = nums[i];
					skip = true;
				}
			}
		}
		return count;
	}
}
