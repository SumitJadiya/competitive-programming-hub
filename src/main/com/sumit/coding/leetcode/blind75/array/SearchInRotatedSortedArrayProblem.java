package com.sumit.coding.leetcode.blind75.array;

/*
 * Problem URL : https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 7
 * Output: 4
 * */
public class SearchInRotatedSortedArrayProblem {

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 3;
        System.out.println(new SearchInRotatedSortedArrayProblem().search(nums, target));
    }

    /*
     * Time Complexity : O(log n)
     * Space Complexity : O(1)
     * */
    public int search(int[] nums, int target) {
        int pivotIndex = findPivotIndex(nums);

        if (nums[pivotIndex] == target) return pivotIndex;

        int start, end;

        if (target >= nums[0]) {
            start = 0;
            end = pivotIndex - 1;
        } else {
            start = pivotIndex + 1;
            end = nums.length - 1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }

    private int findPivotIndex(int[] nums) {
        if (nums.length == 1) return 0;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) return mid;
            if (mid < end && nums[mid] > nums[mid + 1]) return mid + 1;

            if (nums[mid] >= nums[start]) start = mid + 1;
            else end = mid - 1;
        }

        return start;
    }
}
