public class Solution {
    // one way to do it is using dynamic programming which takes around O(n^2) time

    // but there is a very simple way to solve this problem. If we look carefully we
    // will notice that there is an upper bound to number of steps we can take
    // at any particular instant. If we compute the upper bound and note that
    // the last index of the array falls in the upper bound then the destination
    // is reachable.

    // In computing the upper bound we use a variable called step. This variable
    // holds the maximum step size that can be taken at any particular instant.

    // As we move 1 position forward the value of step will decrease by 1 but if
    // the new nums[i] is greater than step then our step will become nums[i]
    // since now we can take a max step size of nums[i]. At any point if step
    // becomes negative that means its not possible to go beyond and by
    // extension reach the last index.
    public boolean canJump(int[] nums) {
    	int n = nums.length;
	    if (n == 0) return false;
	    if (n == 1) return true;

	    int step = nums[0];

	    for (int cur : nums) {
	    	if (step < 0) return false;

	    	if (step < cur) step = cur;

	    	step--;
	    }

    	return true;
    }
}
