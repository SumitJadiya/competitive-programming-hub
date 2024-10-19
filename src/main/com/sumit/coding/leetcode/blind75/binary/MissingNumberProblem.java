package com.sumit.coding.leetcode.blind75.binary;

import java.util.Arrays;

/*
 * Problem URL : https://leetcode.com/problems/missing-number/
 *
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
 * 2 is the missing number in the range since it does not appear in nums.
 * */
public class MissingNumberProblem {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(new MissingNumberProblem().missingNumber(nums));

        nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(new MissingNumberProblem().missingNumber(nums));
    }

    /*
     * Steps:
     * 1. Calculate the expected sum of numbers from 0 to n.
     * 2. Calculate the actual sum of the numbers in the array.
     * 3. The missing number is the difference between the expected sum and the actual sum.
     *
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int totalSum = len * (len + 1) / 2;

        int currentSum = Arrays.stream(nums).sum();

        return totalSum - currentSum;
    }
}
