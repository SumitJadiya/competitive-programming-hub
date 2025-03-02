package com.sumit.coding.patterns.slidingWindow;

/*
 * Given an array of integers nums, and an integer k, return the maximum average of a contiguous subarray of length k.
 * URL : https://www.educative.io/courses/grokking-coding-interview/maximum-average-subarray-i
 * */
public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        int[] nums = {-2};
        int k = 1;

        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;
        int sum = 0;
        int len = nums.length;

        for (int i = 0; i < k; i++)
            sum += nums[i];

        maxAvg = maxAvg(maxAvg, sum, k);

        for (int i = k; i < len; i++) {
            sum += nums[i] - nums[i - k];
            maxAvg = maxAvg(maxAvg, sum, k);
        }

        return maxAvg;
    }

    public static double maxAvg(double maxAvg, int sum, int k) {
        return Math.max(maxAvg, (double) sum / k);
    }
}