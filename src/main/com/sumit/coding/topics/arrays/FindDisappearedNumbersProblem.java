package main.com.sumit.coding.topics.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem URL : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * Find All Numbers Disappeared in an Array
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 */
public class FindDisappearedNumbersProblem {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(new FindDisappearedNumbersProblem().findDisappearedNumbers(nums));
    }

    /**
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) nums[newIndex] *= -1;
        }

        for (int i = 0; i < len; i++)
            if (nums[i] > 0) result.add(i + 1);

        return result;
    }
}
