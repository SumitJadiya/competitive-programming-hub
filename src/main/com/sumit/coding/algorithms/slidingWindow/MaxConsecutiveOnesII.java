package main.com.sumit.coding.algorithms.slidingWindow;

/*
 * URL - https://leetcode.com/problems/max-consecutive-ones-ii/
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
 *
 * Input: nums = [1,0,1,1,0]         Output: 4
 * Explanation:
 * - If we flip the first zero, nums becomes [1,1,1,1,0] and we have 4 consecutive ones.
 * - If we flip the second zero, nums becomes [1,0,1,1,1] and we have 3 consecutive ones.
 *
 * The max number of consecutive ones is 4.
 * */
public class MaxConsecutiveOnesII {

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 1, 1, 0}; // 3
        System.out.println(findMaxConsecutiveOnes(nums));

        nums = new int[]{1, 1, 0, 1, 1, 0, 1}; // 5
        System.out.println(findMaxConsecutiveOnes(nums));

        nums = new int[]{1, 0, 1, 1, 0}; // 4
        System.out.println(findMaxConsecutiveOnes(nums));

        nums = new int[]{1, 0, 1, 1, 0, 1}; // 4
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int idx = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                count = (i - 1 >= 0 && nums[i - 1] == 0) ? 1 : i - idx + 1;
                idx = i + 1;
            } else
                count++;

            if (max < count) max = count;
        }

        return max;
    }
}
