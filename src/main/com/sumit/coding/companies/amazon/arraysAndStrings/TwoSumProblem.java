package main.com.sumit.coding.companies.amazon.arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem URL : https://leetcode.com/problems/two-sum/
 * */
public class TwoSumProblem {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     * */
    public static int[] twoSum(int[] nums, int target) {
        // var cache = new HashMap<Integer, Integer>();
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentSum = target - nums[i];

            if (cache.containsKey(currentSum))
                return new int[]{cache.get(currentSum), i};

            cache.put(nums[i], i);
        }
        return new int[]{};
    }
}
