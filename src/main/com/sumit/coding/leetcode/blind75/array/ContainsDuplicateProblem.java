package com.sumit.coding.leetcode.blind75.array;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem URL : https://leetcode.com/problems/contains-duplicate/description/
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Explanation: The element 1 occurs at the indices 0 and 3.
 * */
public class ContainsDuplicateProblem {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(new ContainsDuplicateProblem().containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) return true;

            set.add(num);
        }

        return false;
    }
}
