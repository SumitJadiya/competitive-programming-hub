package main.com.sumit.coding.sorting;

/*
 * Check if Array Is Sorted and Rotated
 * Problem URL : https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 *
 * Input: nums = [3,4,5,1,2] Output: true
 * Explanation: [1,2,3,4,5] is the original sorted array.
 * You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
 * */
public class CheckIfArrayIsSortedAndRotated {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};

        System.out.println(check(nums));
    }

    private static boolean check(int[] nums) {
        int count = 0;
        int len = nums.length - 1;

        for (int i = 0; i < len; i++)
            if (nums[i] > nums[i + 1]) count++;

        if (nums[len] > nums[0]) count++;

        return count <= 1;
    }
}
