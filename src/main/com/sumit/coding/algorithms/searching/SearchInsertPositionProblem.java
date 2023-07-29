package main.com.sumit.coding.algorithms.searching;

/*
 * Search Insert Position
 * Problem URL : https://leetcode.com/problems/search-insert-position/
 *
 * Input: nums = [1,3,5,6], target = 5, Output: 2
 * Input: nums = [1,3,5,6], target = 2, Output: 1
 * */
public class SearchInsertPositionProblem {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;

        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (nums[mid] == target) break;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;

            mid = start + (end - start) / 2;
        }
        return mid;
    }
}
