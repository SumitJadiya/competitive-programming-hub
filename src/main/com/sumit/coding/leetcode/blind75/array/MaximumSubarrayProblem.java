package com.sumit.coding.leetcode.blind75.array;

/*
 * Problem URL : https://leetcode.com/problems/maximum-subarray/description/
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The sub-array [4,-1,2,1] has the largest sum 6.
 * */
public class MaximumSubarrayProblem {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("max sub array sum : " + new MaximumSubarrayProblem().maxSubArray(nums));

        nums = new int[]{-2};
        System.out.println("max sub array sum : " + new MaximumSubarrayProblem().maxSubArray(nums));

        nums = new int[]{0};
        System.out.println("max sub array sum : " + new MaximumSubarrayProblem().maxSubArray(nums));
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * */
    public int maxSubArray(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currVal = nums[i];
            currSum = Math.max(currVal, currSum + currVal);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
