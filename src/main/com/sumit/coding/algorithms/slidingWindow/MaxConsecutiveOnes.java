package main.com.sumit.coding.algorithms.slidingWindow;

/*
 * URL - https://leetcode.com/problems/max-consecutive-ones/
 *
 * Input: nums = [1,1,0,1,1,1]      Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            if (num == 1) count++;
            else count = 0;

            if (count > max) max = count;
        }

        return max;
    }
}
