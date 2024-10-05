package com.sumit.coding.leetcode.blind75.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem URL -- https://leetcode.com/problems/two-sum/description/
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * */
public class TwoSumProblem {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(new TwoSumProblem().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[2];
        int index = 0;

        for (int num : nums) {
            int complement = target - num;
            if (hm.containsKey(complement)) {
                result[0] = hm.get(complement);
                result[1] = index;
            } else {
                hm.put(num, index);
            }

            index++;
        }

        return result;
    }
}
