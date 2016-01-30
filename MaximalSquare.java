// Passed with runtime more than 90.07% submissions
public class Solution {
	public int maximalSquare(char[][] matrix) {
		int R = matrix.length;
		if (R == 0) return 0;
		
		int C = matrix[0].length;
		if (C == 0) return 0;
		
		int max = 0;
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (matrix[r][c] == '1') {
					int size = maxSquare(matrix, r, c);
					max = Math.max(size, max);
				}
			}
		}
		
		return max;
    }
	
	private int maxSquare(char[][] matrix, int r, int c) {
		int len = 0, R = matrix.length, C = matrix[0].length;
		
		if (r == R || c == C) return 1;
		
		while((r + len + 1) < R && (c + len + 1) < C && verify(matrix, r, c, len + 1)) len++; 
		
		return (len+1)*(len+1);
	}
	
	
	private boolean verify(char[][] matrix, int r, int c, int l) {
		for(int i = 0; i < l+1; i++) {
			if(matrix[r+l][c+i] != '1') return false;
			if(matrix[r+i][c+l] != '1') return false;
		}
		
		return true;
	}
}
