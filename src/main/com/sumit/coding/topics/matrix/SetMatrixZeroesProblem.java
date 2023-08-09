package main.com.sumit.coding.topics.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Problem URL : https://leetcode.com/problems/set-matrix-zeroes/
 * */
public class SetMatrixZeroesProblem {
    static int[][] A;

    public static void main(String[] args) {
        A = new int[][]{{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        setZeroes(A);
        printA();

        System.out.println("-------- ");

        A = new int[][]{{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        new SetMatrixZeroesProblem().setZeroes_secondApproach(A);
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
     * Time Complexity : O(m x n)
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

    /*
     * Time Complexity : O(m x n)
     * Space Complexity : O(m + n)
     * */
    public void setZeroes_secondApproach(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (rows.contains(i) || cols.contains(j))
                    matrix[i][j] = 0;
    }

}
