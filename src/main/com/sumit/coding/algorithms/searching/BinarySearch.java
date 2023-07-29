package main.com.sumit.coding.algorithms.searching;

/*
 * Problem URL : https://leetcode.com/problems/binary-search/
 * */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;

        System.out.println(new BinarySearch().search(nums, target));
    }

    /*
     * Time Complexity : O(logN)
     * */
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target) {

        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) return mid;

        if (nums[mid] > target) return binarySearch(nums, 0, mid - 1, target);

        return binarySearch(nums, mid + 1, end, target);
    }
}
