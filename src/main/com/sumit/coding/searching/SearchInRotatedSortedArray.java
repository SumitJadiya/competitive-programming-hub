package main.com.sumit.coding.searching;

/*
 * Search in Rotated Sorted Array
 * Problem URL : https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(search(nums, target));
    }

    private static int findPivotIndexOfRotatedArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;

        while (start < end) {
            if (nums[mid] >= nums[0]) start = mid + 1;
            else end = mid;

            mid = start + (end - start) / 2;
        }
        return start;
    }

    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int pivotIdx = findPivotIndexOfRotatedArray(nums);

        if (nums[pivotIdx] <= target && target <= nums[end])
            start = pivotIdx;
        else end = pivotIdx - 1;

        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;

            mid = start + (end - start) / 2;
        }
        return -1;
    }
}
