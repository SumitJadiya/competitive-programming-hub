package main.com.sumit.coding.topics.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Find All Duplicates in an Array
 * URL : https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n]
 * and each integer appears once or twice, return an array of all the integers that appears twice.
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * */
public class FindAllDuplicatesInArray {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new FindAllDuplicatesInArray().findDuplicates(nums));
    }

    private List<Integer> findDuplicates(int[] nums) {
        var list = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                list.add(index + 1);

            nums[index] = -nums[index];
        }

        return list;
    }
}
