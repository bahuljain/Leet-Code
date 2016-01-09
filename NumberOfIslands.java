public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;

        int n = grid[0].length;
        if(n == 0) return 0;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    grid = scout(i,j,grid);
                    count++;
                }
            }
        }

        return count;
    }

    public char[][] scout(int i, int j, char[][] grid) {

        if(grid[i][j] == '1') {
            grid[i][j] = '0';
            if(i+1 < grid.length) grid = scout(i+1,j,grid);
            if(j+1 < grid[0].length) grid = scout(i,j+1,grid);
            if(i-1 >= 0) grid = scout(i-1,j,grid);
            if(j-1 >= 0) grid = scout(i,j-1,grid);
        }

        return grid;
    }
}
