package com.sumit.coding.leetcode.blind75.array;

import java.util.Arrays;

/*
 * Problem URL : https://leetcode.com/problems/product-of-array-except-self/description/
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * */
public class ProductOfArrayExceptSelfProblem {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};

        System.out.println(
                Arrays.stream(new ProductOfArrayExceptSelfProblem().productExceptSelf(nums))
        );
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        result[0] = 1;

        for (int i = 1; i < length; i++)
            result[i] = result[i - 1] * nums[i - 1];

        int suffixProduct = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = result[i] * suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }
}
