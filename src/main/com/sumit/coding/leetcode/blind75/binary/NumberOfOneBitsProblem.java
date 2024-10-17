package com.sumit.coding.leetcode.blind75.binary;

/*
 * Problem URL : https://leetcode.com/problems/number-of-1-bits/description/
 *
 * Example 1:
 * Input: n = 11
 * Output: 3
 * Explanation: The input binary string 1011 has a total of three set bits.
 *
 * Example 2:
 * Input: n = 128
 * Output: 1
 * Explanation: The input binary string 10000000 has a total of one set bit.
 *
 * Example 3:
 * Input: n = 2147483645
 * Output: 30
 * Explanation: The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
 * */

public class NumberOfOneBitsProblem {

    public static void main(String[] args) {
        int n = 11;
        System.out.println(new NumberOfOneBitsProblem().hammingWeight(n));

        n = 128;
        System.out.println(new NumberOfOneBitsProblem().hammingWeight(n));

        n = 2147483645;
        System.out.println(new NumberOfOneBitsProblem().hammingWeight(n));

    }

    /*
     * Time Complexity : O(k), K: number of bits
     * Space Complexity : O(1)
     * */
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1)
                count++;

            n = n >> 1;
        }

        return count;
    }
}