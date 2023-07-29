package main.com.sumit.coding.topics.matrix;

import java.util.Arrays;

/*
 * Problem URL : https://leetcode.com/problems/set-matrix-zeroes/
 * */
public class SetMatrixZeroesProblem {
    static int[][] A;

    public static void main(String[] args) {
        A = new int[][]{{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        setZeroes(A);
        printA();
    }

    private static void printA() {
        for (int[] ints : A) {
            for (int j = 0; j < A[0].length; j++)
                System.out.print(ints[j] + " ");
            System.out.println();
        }
    }

    /*
     * Time Complexity : O(m+n)
     * Space Complexity : O(1)
     * */
    public static void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        if (fr) Arrays.fill(matrix[0], 0);

        if (fc)
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
    }
}
