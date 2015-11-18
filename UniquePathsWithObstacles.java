public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(obstacleGrid[i-1][j-1] == 1) {
                    paths[i][j] = 0;
                } else {
                    if(i == 1 && j == 1) paths[i][j] = 1;
                    else if (i == 1 && j != 1) paths[i][j] = paths[i][j-1];
                    else if (i != 1 && j == 1) paths[i][j] = paths[i-1][j];
                    else paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
        }
        return paths[m][n];
    }
}
