package com.sumit.coding.leetcode.blind75.array;

/*
 * Problem URL : https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * */
public class MaximumProductSubarrayProblem {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("max product : " + new MaximumProductSubarrayProblem().maxProduct(nums));

        nums = new int[]{2, 3, -2, 4};
        System.out.println("max product : " + new MaximumProductSubarrayProblem().maxProduct(nums));

        nums = new int[]{-2, 0, -1};
        System.out.println("max product : " + new MaximumProductSubarrayProblem().maxProduct(nums));

    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     * */
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int idx = 1; idx < nums.length; idx++) {
            int curr = nums[idx];

            if (curr < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(curr, curr * maxProduct);
            minProduct = Math.min(curr, curr * minProduct);

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
