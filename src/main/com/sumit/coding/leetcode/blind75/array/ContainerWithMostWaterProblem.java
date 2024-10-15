package com.sumit.coding.leetcode.blind75.array;

/*
 * Problem URL : https://leetcode.com/problems/container-with-most-water/
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * */
public class ContainerWithMostWaterProblem {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWaterProblem().maxArea(height));

        height = new int[]{1, 1};
        System.out.println(new ContainerWithMostWaterProblem().maxArea(height));
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * */
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int maxArea = 0;

        while (start < end) {
            int width = end - start;
            maxArea = Math.max(Math.min(height[start], height[end]) * width, maxArea);

            if (height[start] < height[end]) start++;
            else end--;
        }

        return maxArea;
    }
}
