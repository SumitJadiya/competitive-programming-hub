package main.com.sumit.coding.google.arraysAndStrings;

/*
 * Problem URL : https://leetcode.com/problems/container-with-most-water/
 * Input: height = [4,3,2,1,4]
 * Output: 16
 * */
public class ContainerWithMostWaterProblem {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1, 4};
        new ContainerWithMostWaterProblem().maxArea(nums);
    }

    /*
     * Time Complexity : O(N),
     * Space Complexity : O(1)
     * */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentMax = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(currentMax, max);

            if ((height[left] == Math.min(height[left], height[right])))
                left++;
            else
                right--;
        }
        return max;
    }
}
