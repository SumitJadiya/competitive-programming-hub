package main.com.sumit.coding.arrays;

/*
 * Move Zeroes
 * Problem URL : https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3286/
 * */
public class MoveZeroesProblem {

    public static void main(String[] args) {
        int[] arr = {0, 2, 0, 1};
        moveZeroes(arr);

        for (int j : arr) System.out.print(j + " ");
    }

    /*
     * Time Complexity : O(n)
     * */
    private static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[j++] = nums[i];
        }
        while (j < nums.length)
            nums[j++] = 0;
    }
}
