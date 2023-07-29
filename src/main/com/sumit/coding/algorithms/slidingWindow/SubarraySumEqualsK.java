package main.com.sumit.coding.algorithms.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
 * URL - https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * Given an array of integers nums and an integer k, return the total number of sub-arrays whose sum equals to k.
 * A sub-array is a contiguous non-empty sequence of elements within an array.
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * */
public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, k));

        nums = new int[]{1, 2, 3};
        k = 3;
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
