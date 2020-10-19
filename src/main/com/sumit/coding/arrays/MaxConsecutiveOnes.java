package main.com.sumit.coding.arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) count++;
            else count = 0;

            if(count > max) max = count;
        }

        return max;
    }
}
