public class Solution {
	boolean[][] visited;
	int[][] maxPath;

    public int longestIncreasingPath(int[][] matrix) {
    	int r = matrix.length;
    	if (r == 0) return 0;

    	int c = matrix[0].length;
    	if (c == 0) return 0;

    	visited = new boolean[r][c];
    	maxPath = new int[r][c];
    	int max = 0;

    	for (int i = 0; i < r; i++) {
    		for (int j = 0; j < c; j++) {
    			int m = findMaxPath(i, j, matrix);
    			max = (m > max) ? m : max;
    		}
    	}

    	return max;
    }

	private int findMaxPath(int i, int j, int[][] matrix) {
		if (visited[i][j]) return maxPath[i][j];

		int max = 1;
		int cur = matrix[i][j];

		if (i - 1 >= 0){
			if (matrix[i-1][j] > cur) {
				max = Math.max(max, 1 + findMaxPath(i - 1, j, matrix));
			}
		}

		if (i + 1 < matrix.length){
			if (matrix[i + 1][j] > cur) {
				max = Math.max(max, 1 + findMaxPath(i + 1, j, matrix));
			}
		}

		if (j - 1 >= 0){
			if (matrix[i][j - 1] > cur) {
				max = Math.max(max, 1 + findMaxPath(i, j - 1, matrix));
			}
		}

		if (j + 1 < matrix[0].length){
			if (matrix[i][j + 1] > cur) {
				max = Math.max(max, 1 + findMaxPath(i, j + 1, matrix));
			}
		}

		visited[i][j] = true;
		maxPath[i][j] = max;

		return max;
	}
}
