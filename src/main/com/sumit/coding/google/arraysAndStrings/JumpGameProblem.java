package main.com.sumit.coding.google.arraysAndStrings;

/*
 * Problem URL : https://leetcode.com/problems/jump-game/
 * */
public class JumpGameProblem {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * */
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--)
            if (i + nums[i] >= lastPos) lastPos = i;

        return lastPos == 0;
    }
}
