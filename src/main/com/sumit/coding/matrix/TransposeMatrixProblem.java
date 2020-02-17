package main.com.sumit.coding.matrix;

/**
 * Transpose of matrix
 */
public class TransposeMatrixProblem {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        transpose(mat);
    }

    /**
     * method to print
     *
     * @param mat Input Matrix
     */
    private static void printMatrix(int[][] mat) {
        for (int[] ints : mat) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     * method to transpose
     *
     * @param mat Input matrix
     */
    private static void transpose(int[][] mat) {

        for (int i = 0; i < mat.length; i++)
            for (int j = i + 1; j < mat[i].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        printMatrix(mat);
    }
}
