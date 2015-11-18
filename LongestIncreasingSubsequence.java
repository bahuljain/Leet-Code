public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        //2 4 3 6 5
        int[] lis = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
        	lis[i] = 1;
        	for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
			max = Math.max(max, lis[i]);
        }
        return max;
    }
}
