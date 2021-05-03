package main.com.sumit.coding.arrays;

/*
    Problem : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3730/

    Example 1:
    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

    Example 2:
    Input: nums = [1,1,1,1,1]
    Output: [1,2,3,4,5]
    Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

    Example 3:
    Input: nums = [3,1,2,10,1]
    Output: [3,4,6,16,17]
*/
public class RunningSumOfOneDArray {

    public static void main(String[] args) {
        System.out.println(new RunningSumOfOneDArray().runningSum(new int[]{1, 2, 3, 4}));
    }

    public int[] runningSum(int[] nums) {

        int index = 0, sum = 0;
        int[] result = new int[nums.length];

        for(int i : nums) {
            result[index] = i + sum;
            sum = result[index];
            index++;
        }

        return result;
    }
}
