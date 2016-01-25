public class Solution {
	public void solve(char[][] board) {
		int m = board.length;
		if (m == 0)	return;

		int n = board[0].length;
		if (n == 0) return;

		// top and bottom boundary
		for (int i = 0; i < n; i++) {
			board = scout(0, i, board);
			board = scout(m - 1, i, board);
		}

		// right and left boundary
		for (int i = 1; i < m - 1; i++) {
			board = scout(i, n - 1, board);
			board = scout(i, 0, board);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') board[i][j] = 'X';
			    else if (board[i][j] == '-') board[i][j] = 'O';
			}
		}
	}

	public char[][] scout(int i, int j, char[][] grid) {

		if (grid[i][j] == 'O') {
			grid[i][j] = '-';

			if (i + 1 < grid.length - 1)
				grid = scout(i + 1, j, grid);

			if (j + 1 < grid[0].length - 1)
				grid = scout(i, j + 1, grid);

			if (i - 1 > 0)
				grid = scout(i - 1, j, grid);

			if (j - 1 > 0)
				grid = scout(i, j - 1, grid);
		}

		return grid;
	}
}
