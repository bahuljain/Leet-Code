//bitch problem this was...surprisingly there was a very easy solution to this.
//should have gotten this
public class UniqueBST {
    public int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;

        for(int j = 1; j <= n; j++) {
            int s = 0;

            for(int i = 0; i < j; i++){
                s += nums[i] * nums[j - 1 - i];
            }
            nums[j] = s;
        }
        return nums[n];
    }
}
