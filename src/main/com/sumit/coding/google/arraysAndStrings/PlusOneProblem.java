package main.com.sumit.coding.google.arraysAndStrings;

import java.util.Arrays;

/*
 * Problem URL: https://leetcode.com/problems/plus-one
 * */
public class PlusOneProblem {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(new PlusOneProblem().plusOne(nums)));
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     * */
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;

            if (digits[i] != 0) return digits;
        }

        // handling for 9, 99, 999 etc
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
