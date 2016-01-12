public class Solution {
    // since we have numbers from 1 to n only...we pick that as low and high
    // respectively. Choose the middle number as reference and check how many
    // numbers in array are greater than or less than equal to it.

    // If there are more numbers greater than it then it means the duplicate
    // will be between low and the mid, else it'll be between mid + 1 and high

    // apply this logic repeatedly till high and low will both point to the
    // duplicate number.
    public int findDuplicate(int[] nums) {
    	if (nums.length == 0 || nums == null)
			return 0;
		int low = 1, high = nums.length - 1, mid;
		while (low < high) {
			mid = low + (high - low) / 2;
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid)
					count++;
			}
			if (count > mid)
				high = mid;
			else
				low = mid + 1;
		}
		return low;
    }
}
