package main.com.sumit.coding.leetcode.Oct20;

import java.util.Stack;

/*
* URL :
* https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3505/
* */
public class Problem23 {

    public static void main(String[] args) {

        int[] nums = {-1,3,2,0};
        System.out.println(new Problem23().find132pattern_brute(nums));
        System.out.println(new Problem23().find132pattern_betterBrute(nums));
        System.out.println(new Problem23().find132pattern_usingStack(nums));
    }

    public boolean find132pattern_brute(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > nums[i] && nums[j] > nums[k])
                        return true;
                }
            }
        }
        return false;
    }

    public boolean find132pattern_betterBrute(int[] nums) {
        int min_i = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length - 1; j++) {
            min_i = Math.min(min_i, nums[j]);
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[j] && min_i < nums[k])
                    return true;
            }
        }
        return false;
    }

    public boolean find132pattern_usingStack(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack<Integer> stack = new Stack();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);

        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }
}
