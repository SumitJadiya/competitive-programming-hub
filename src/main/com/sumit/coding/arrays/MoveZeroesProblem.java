package main.com.sumit.coding.arrays;

/*
 *
 * Problem URL
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3286/
 *
 * */
public class MoveZeroesProblem {

    public static void main(String[] args) {
        int[] arr = {2, 1};
        new MoveZeroesProblem().moveZeroes(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[j++] = nums[i];
        }
        while (j < nums.length)
            nums[j++] = 0;
    }
}
