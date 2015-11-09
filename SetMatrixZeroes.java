public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        BitSet row = new BitSet(m);
        BitSet col = new BitSet(n);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j]==0) {
                    row.set(i);
                    col.set(j);
                }
            }
        }

        for(int i = row.nextSetBit(0); i < m && i >= 0; i=row.nextSetBit(i+1)) {
            for(int j = 0; j < n; j++) matrix[i][j] = 0;
        }

        for(int i = col.nextSetBit(0); i < n && i >= 0; i=col.nextSetBit(i+1)) {
            for(int j = 0; j < m; j++) matrix[j][i] = 0;
        }

    }
    // a neat way to save memory would be treat the first row and first column
    // as those contains info about which rows & cols should be zeroes. In this
    // case you should also explicity find out whether row zero and column zero
    // should be also be set to all zeroes
}
