package main.com.sumit.coding.companies.microsoft;

/*
 * Problem URL - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
 * */
public class FindMinimumInRotatedSortedArrayProblem {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(new FindMinimumInRotatedSortedArrayProblem().findMin(nums));
    }

    /*
     * Time Complexity - O(N)
     * */
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if (nums.length == 1 || nums[start] < nums[end]) return nums[start];

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid - 1] > nums[mid]) return nums[mid];

            if (nums[mid] > nums[0]) start = mid;
            else if (nums[mid] < nums[0]) end = mid - 1;
        }

        return nums[start];
    }
}
