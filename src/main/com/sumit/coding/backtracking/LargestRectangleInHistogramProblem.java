package main.com.sumit.coding.backtracking;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Problem URL : https://leetcode.com/problems/largest-rectangle-in-histogram/
 * */
public class LargestRectangleInHistogramProblem {

    public static void main(String[] args) {
        int[] height = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(height));
    }

    /*
     * Time complexity : O(n). n numbers are pushed and popped.
     * Space complexity : O(n). Stack is used.
     * */
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            while ((stack.peek() != -1) && (heights[stack.peek()] >= heights[i]))
                maxArea = findMaxArea(heights, stack, maxArea, i);

            stack.push(i);
        }
        while (stack.peek() != -1)
            maxArea = findMaxArea(heights, stack, maxArea, length);

        return maxArea;
    }

    public static int findMaxArea(int[] heights, Deque<Integer> stack, int maxArea, int i) {
        int currentHeight = heights[stack.pop()];
        int currentWidth = i - stack.peek() - 1;
        return Math.max(maxArea, currentHeight * currentWidth);
    }
}
