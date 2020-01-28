package com.sumit.coding.matrix;

/**
 * Problem URL:
 * https://practice.geeksforgeeks.org/problems/print-matrix-in-snake-pattern/1/?track=SPC-Matrix&batchId=135
 */
public class SnakePatternProblem {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        printSnakePattern(mat);
    }

    /**
     * Code to print Snake Pattern
     *
     * @param mat input matrix
     */
    private static void printSnakePattern(int[][] mat) {
        int size = mat.length;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < mat[i].length; j++) {
                    System.out.print(mat[i][j] + " ");
                }
            } else {
                for (int j = mat[i].length - 1; j >= 0; j--) {
                    System.out.print(mat[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
