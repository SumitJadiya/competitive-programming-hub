package main.com.sumit.coding.topics.arrays;

import java.util.Arrays;

/*
 * URL - https://leetcode.com/problems/maximum-average-subarray-i/description/
 * */
public class MaximumAverageSubarray {

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println("result is = " + new MaximumAverageSubarray().findMaxAverage(nums, k));
        System.out.println("result is = " + new MaximumAverageSubarray().findMaxAverage__2(nums, k));
        nums = new int[]{4, 2, 1, 3, 3};
        k = 2;
        System.out.println("result is = " + new MaximumAverageSubarray().findMaxAverage(nums, k));
        System.out.println("result is = " + new MaximumAverageSubarray().findMaxAverage__2(nums, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return res / k;
    }

    public double findMaxAverage__2(int[] nums, int k) {
        double sum = Arrays.stream(nums, 0, k).sum();

        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return res / k;
    }
}
