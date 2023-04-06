package main.com.sumit.coding.algorithms.slidingWindow;

/*
 * URL - https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2          Output: 6
 *
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest sub-array is underlined.
 * */
public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k));

        nums = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        k = 3;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {

        int i = 0, j;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] == 0) k--;
            if (k < 0 && nums[i++] == 0) k++;
        }
        return j - i;
    }
}
