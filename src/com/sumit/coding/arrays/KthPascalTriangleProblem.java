package com.sumit.coding.arrays;


/**
 * Problem URL :
 * https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
 */
public class KthPascalTriangleProblem {
    public static void main(String[] args) {
        int n = 3;
        int[] result = kthPascalTriangle(n);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    /**
     * @param n Input Parameter
     * @return Returns nth row of Pascal Triangle
     */
    private static int[] kthPascalTriangle(int n) {
        int z[] = new int[n + 1];
        z[0] = 1;
        for (int i = 1; i < n + 1; i++)
            z[i] = z[i - 1] * (n - i + 1) / i;

        return z;
    }
}
