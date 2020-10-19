package main.com.sumit.coding.leetcode.Oct20;

/*
* URL
* https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3494/
* */
public class Problem14 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Problem14().rob(nums));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int dp[] = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i=1; i<nums.length; i++)
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);

        return dp[nums.length];
    }
}
