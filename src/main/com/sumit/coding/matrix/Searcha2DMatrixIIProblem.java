package main.com.sumit.coding.matrix;

/*
 * Problem URL : https://leetcode.com/problems/search-a-2d-matrix-ii/
 * */
public class Searcha2DMatrixIIProblem {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        System.out.println(searchMatrix(mat, 4));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target)
                row--;
            else if (matrix[row][col] < target)
                col++;
            else // found it
                return true;
        }

        return false;
    }
}
