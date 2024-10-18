package com.sumit.coding.leetcode.blind75.binary;

import java.util.Arrays;

/*
 * Problem URL : https://leetcode.com/problems/counting-bits/
 *
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 *      0 --> 0
 *      1 --> 1
 *      2 --> 10
 * */
public class CountingBitsProblem {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(Arrays.toString(new CountingBitsProblem().countBits(n)));
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++)
            result[i] = result[i >> 1] + (i & 1);

        return result;
    }
}
