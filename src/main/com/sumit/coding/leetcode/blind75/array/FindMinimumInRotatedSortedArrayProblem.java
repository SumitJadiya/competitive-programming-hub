package com.sumit.coding.leetcode.blind75.array;

/*
 * Problem URL : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * */
public class FindMinimumInRotatedSortedArrayProblem {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 1, 2};
        System.out.println("Min : " + new FindMinimumInRotatedSortedArrayProblem().findMin(nums));

        nums = new int[]{11, 13, 15, 17};
        System.out.println("Min : " + new FindMinimumInRotatedSortedArrayProblem().findMin(nums));

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println("Min : " + new FindMinimumInRotatedSortedArrayProblem().findMin(nums));

    }

    /*
     * Time Complexity : O(log N)
     * Space Complexity : O(1)
     * */
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int start = 0;
        int end = nums.length - 1;

        // check for already sorted
        if (nums[start] < nums[end]) return nums[start];

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid;
        }

        return nums[start];
    }
}
