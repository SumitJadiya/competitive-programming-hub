package main.com.sumit.coding.algorithms.twoPointers;

/*
 * Given an array of positive numbers, nums, such that the values lie in the range [1,n], inclusive, and that there are n+1
 * numbers in the array, find and return the duplicate number present in nums. There is only one repeated number in nums.
 *
 * Note: You cannot modify the given array nums. You have to solve the problem using only constant extra space.
 * */
public class FindTheDuplicateNumberProblem {

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 4, 4, 2};
        System.out.println(findDuplicate(nums));

        nums = new int[]{1, 3, 3, 4, 2, 5};
        System.out.println(findDuplicate(nums));
    }
}
