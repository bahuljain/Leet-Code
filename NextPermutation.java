public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;

        // 1. So start from the right most digit and keep checking if the digit on its
        // left is greater than equal to itself...
        // 2. if so then just move to the left digit
        // 3. if not then stop and store the current position as cur
        int cur = n - 1;
        while(cur > 0) {
            if (nums[cur - 1] < nums[cur]) break;
            cur--;
        }

        // 4. reverse all elements from cur to end of array
        nums = reverse(nums, cur, n - 1);

        // 5. now if in steps 1-3 we keep moving to the left and evetually reach
        // the start then cur = 0. This means the number is arranged in
        // descending order. We just have to reverse the entire array which we
        // did in step 4. and so we are done.

        // 6. But if cur is not the first position in the array, then again as per
        // step 4 we have reversed the array from cur to the end. Now starting from
        // cur we find the first element which is greater than num[cur - 1]. We
        // simply swap the two and we are done.
        if (cur > 0) {
        	for (int i = cur; i < n; i++) {
        		if (nums[i] > nums[cur - 1]) {
        			nums = swap(nums, i, cur - 1);
        			break;
        		}
        	}
        }
    }

	public int[] reverse(int[] nums, int start, int end) {
		for (int i = start; i <= (start + end)/2; i++) {
			nums = swap(nums, i, end - (i - start));
		}

		return nums;
	}

	public int[] swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    	return nums;
    }
}
