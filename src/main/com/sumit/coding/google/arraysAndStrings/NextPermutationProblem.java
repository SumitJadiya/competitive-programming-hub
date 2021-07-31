package main.com.sumit.coding.google.arraysAndStrings;

/*
 * Problem URL : https://leetcode.com/problems/next-permutation/
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * */
public class NextPermutationProblem {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new NextPermutationProblem().nextPermutation(nums);
    }

    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) i--;

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
