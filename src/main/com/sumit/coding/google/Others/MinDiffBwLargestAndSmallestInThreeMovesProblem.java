package main.com.sumit.coding.google.Others;

import java.util.Arrays;

/*
 * Problem URL : https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 *
 * Input: nums = [5,3,2,4] Output: 0
 * Explanation: Change the array [5,3,2,4] to [2,2,2,2]. The difference between the maximum and minimum is 2-2 = 0.
 * */
public class MinDiffBwLargestAndSmallestInThreeMovesProblem {

    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 10, 14};
        System.out.println(minDifference(nums));
    }

    /*
     * Time Complexity : O(N logN)
     * */
    public static int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;

        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++)
            result = Math.min(result, nums[n - 1 - 3 + i] - nums[i]);

        return result;
    }
}
