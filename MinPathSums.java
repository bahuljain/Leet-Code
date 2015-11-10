public class MinPathSums {

    // with using additional space...do not use this...
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;

        int[][] minPath = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1) minPath[i][j] = minPath[i][j-1] + grid[i-1][j-1];
                else if(j == 1) minPath[i][j] = minPath[i-1][j] + grid[i-1][j-1];
                else {
                    int min = (minPath[i-1][j] > minPath[i][j-1]) ? minPath[i][j-1] : minPath[i-1][j];
                    minPath[i][j] = grid[i-1][j-1] + min;
                }
            }
        }
        return minPath[m][n];
    }

    //without using additional space ... this looks soo much better :) :P
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0) grid[i][j] += grid[i][j-1];
                else if(j == 0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += (grid[i-1][j] > grid[i][j-1]) ? grid[i][j-1] : grid[i-1][j];
            }
        }
        return grid[m-1][n-1];
    }
}
