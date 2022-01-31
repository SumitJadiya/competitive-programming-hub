package main.com.sumit.coding.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 *  Problem Statement : Given an array nums of size n, return the majority element.
 *  The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *  URL : https://leetcode.com/problems/majority-element/
 *
 *  Example 1:
 *  Input: nums = [3,2,3]
 *  Output: 3
 * */
public class MajorityElementProblem {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2, 1, 2};
        System.out.println(new MajorityElementProblem().majorityElement_usingHashMap(nums));
        System.out.println(new MajorityElementProblem().majorityElement_usingMooreVoting(nums));
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     * */
    public int majorityElement_usingMooreVoting(int[] nums) {
        int count = 0, ret = 0;
        for (int num : nums) {
            if (count == 0)
                ret = num;
            if (num != ret)
                count--;
            else
                count++;
        }
        return ret;
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     * */
    public int majorityElement_usingHashMap(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);

        int majorityIndex = nums.length / 2;

        for (int key : count.keySet())
            if (count.get(key) > majorityIndex)
                return key;

        return -1;
    }
}
