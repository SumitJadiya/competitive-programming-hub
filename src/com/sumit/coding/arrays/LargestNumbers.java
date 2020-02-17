package com.sumit.coding.arrays;

import java.util.Arrays;

/*
 *
 *   Problem URL:
 *   https://www.interviewbit.com/problems/largest-number/
 *
 * */
public class LargestNumbers {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr));
    }

    private static String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        String[] num = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            num[i] = Integer.toString(nums[i]);
        Arrays.sort(num, (a, b) -> ((b + a).compareTo(a + b)));
        for (int i = 0; i < nums.length; i++) {
            res.append(num[i]);
        }
        String ans = res.toString();
        if (ans.charAt(0) == '0')
            return "0";
        return ans;
    }
}
