public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        if( n == 0 ) return nums;

        for(int[] rows: nums) {
            Arrays.fill(rows, -1);
        }

        // direction = 1 : right and down; direction = -1 : left and up
        int direction = 1;

        // dimension = true : x axis ; dimension = false : y axis
        boolean dimension = true;
        int num = 1;

        int i = 0, j = 0;

        while(num <= Math.pow(n, 2)) {
            if(dimension){
                if(j < n && j >= 0 && nums[i][j] == -1) {
                    nums[i][j] = num++;
                    j += direction;
                } else {
                    j -= direction;
                    i += direction;
                    dimension = !dimension;
                }
            } else {
                if(i < n && i >= 0 && nums[i][j] == -1) {
                    nums[i][j] = num++;
                    i += direction;
                } else {
                    i -= direction;
                    direction *= -1;
                    j += direction;
                    dimension = !dimension;
                }
            }
        }

        return nums;
    }
}
