package main.com.sumit.coding.arrays;

import java.util.Arrays;

/**
 * Find Pivot Index
 * Problem URL : https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
 * <p>
 * or
 * <p>
 * Find the Middle Index in Array
 * Problem URL : https://leetcode.com/problems/find-the-middle-index-in-array/
 */
public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println("Pivot Index is -> " + (new FindPivotIndex()).pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum(), leftsum = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
