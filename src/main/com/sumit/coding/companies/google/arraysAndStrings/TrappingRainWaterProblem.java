package main.com.sumit.coding.companies.google.arraysAndStrings;

/*
 * Problem URL : https://leetcode.com/problems/trapping-rain-water/
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * */
public class TrappingRainWaterProblem {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * */
    public static int trap(int[] height) {
        int result = 0;
        int leftPtr = 0, rightPtr = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (leftPtr < rightPtr) {
            if (height[leftPtr] < height[rightPtr]) {
                if (height[leftPtr] >= leftMax)
                    leftMax = height[leftPtr];
                else
                    result += (leftMax - height[leftPtr]);

                ++leftPtr;
            } else {
                if (height[rightPtr] >= rightMax)
                    rightMax = height[rightPtr];
                else
                    result += (rightMax - height[rightPtr]);

                --rightPtr;
            }
        }
        return result;
    }
}
