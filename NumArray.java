public class NumArray {
    int[] nums;
    int[][] sumNums;
    public NumArray(int[] nums) {
        this.nums = nums;
        sumNums = new int[nums.length][nums.length];
        computeAllRangeSums();
    }

    public void computeAllRangeSums() {
        for(int i = 0; i < nums.length; i++) {
            sumNums[i][i] = nums[i];
        }

        if(nums.length > 1) {
            for(int j = 1; j < nums.length; j++) {
                sumNums[0][j] = sumNums[0][j-1] + nums[j];
            }

            for(int i = 1; i < nums.length; i++) {
                for(int j = i+1; j < nums.length; j++) {
                    sumNums[i][j] = sumNums[0][j] - sumNums[0][i-1];
                }
            }
        }
    }

    public int sumRange(int i, int j) {
        return sumNums[i][j];
    }
}
