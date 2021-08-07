package main.com.sumit.coding.matrix;

/*
 * Problem URL : https://leetcode.com/problems/search-a-2d-matrix/
 * */
public class Searcha2DMatrixProblem {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        System.out.println(searchMatrix(mat, 4));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;

        int left = 0, right = row * col - 1;
        int pivotIdx, pivotElement;

        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / col][pivotIdx % col];

            if (pivotElement == target) return true;
            else {
                if (pivotElement < target) left = pivotIdx + 1;
                else right = pivotIdx - 1;
            }
        }
        return false;
    }
}
