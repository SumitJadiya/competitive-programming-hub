package main.com.sumit.coding.google.SearchingSorting;

import java.util.Arrays;

/*
 * Problem URL : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * */
public class FindFirstAndLastPositionOfElementInSortedArrayProblem {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArrayProblem().searchRange(nums, target)));
    }

    /*
     * Time Complexity : O(logN)
     * Space Complexity : O(1)
     * */
    public int[] searchRange(int[] nums, int target) {
        int firstOccurrence = this.findBound(nums, target, true);
        if (firstOccurrence == -1) return new int[]{-1, -1};

        int lastOccurrence = this.findBound(nums, target, false);
        return new int[]{firstOccurrence, lastOccurrence};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int N = nums.length;
        int begin = 0, end = N - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;

            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == begin || nums[mid - 1] != target)
                        return mid;
                    end = mid - 1;
                } else {
                    if (mid == end || nums[mid + 1] != target)
                        return mid;
                    begin = mid + 1;
                }
            } else if (nums[mid] > target)
                end = mid - 1;
            else
                begin = mid + 1;
        }
        return -1;
    }

}
