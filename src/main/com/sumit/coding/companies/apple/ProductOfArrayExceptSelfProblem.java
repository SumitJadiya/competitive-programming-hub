package main.com.sumit.coding.companies.apple;

import java.util.Arrays;

/*
 * Problem URL - https://leetcode.com/problems/product-of-array-except-self/
 * */
public class ProductOfArrayExceptSelfProblem {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelfProblem().productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = 1;

        // left iteration
        for (int i = 1; i < len; i++)
            answer[i] = answer[i - 1] * nums[i - 1];

        // right iteration
        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            answer[i] *= R;
            R *= nums[i];
        }

        return answer;
    }
}
