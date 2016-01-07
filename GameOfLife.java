public class Solution {
    // in place solution

    // info about current state of self -> stored in units place
    
    // info needed to predict next state is the sum of states of neighbors ->
    // stored in tens place
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int pop = get(board,i,j+1) + get(board,i+1,j+1) + get(board,i+1,j) + get(board,i+1,j-1)
                    + get(board,i,j-1) + get(board,i-1,j-1) + get(board,i-1,j) + get(board,i-1,j+1);

                board[i][j] += (pop * 10);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] / 10 < 2 || board[i][j] / 10 > 3) board[i][j] = 0;
                else if (board[i][j] / 10 == 3) board[i][j] = 1;
                else board[i][j] = board[i][j] % 10;
            }
        }
    }

    public int get(int[][] board, int i, int j) {
        return (i < 0 || i >= board.length || j < 0 || j >= board[0].length) ? 0 : board[i][j] % 10;
    }
}
