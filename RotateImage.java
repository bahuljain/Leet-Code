public class RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size / 2; i++) {
            for (int j = i; j < size - i - 1; j++) {
                int tempi = i, tempj = j, temps;
                int temp = matrix[tempj][size - tempi - 1];

                matrix[tempj][size - tempi - 1] = matrix[tempi][tempj];
                temps = tempi;
                tempi = tempj;
                tempj = size - temps - 1;

                int temp2 = matrix[tempj][size - tempi - 1];
                matrix[tempj][size - tempi - 1] = temp;
                temps = tempi;
                tempi = tempj;
                tempj = size - temps - 1;

                temp = matrix[tempj][size - tempi - 1];
                matrix[tempj][size - tempi - 1] = temp2;
                temps = tempi;
                tempi = tempj;
                tempj = size - temps - 1;

                temp2 = matrix[tempj][size - tempi - 1];
                matrix[tempj][size - tempi - 1] = temp;
            }
        }

    }
}
