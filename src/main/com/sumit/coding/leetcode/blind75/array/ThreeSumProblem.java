package com.sumit.coding.leetcode.blind75.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem URL : https://leetcode.com/problems/3sum/description/
 * */
public class ThreeSumProblem {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSumProblem().threeSum(nums));

        nums = new int[]{-2, 1, 1};
        System.out.println(new ThreeSumProblem().threeSum(nums));

        nums = new int[]{0, 0, 0};
        System.out.println(new ThreeSumProblem().threeSum(nums));
    }

    /*
     * Time Complexity : O(n^2)
     * Space Complexity : O(1)
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = len - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target)
                    left++;
                else
                    right--;
            }
        }

        return result;
    }
}
