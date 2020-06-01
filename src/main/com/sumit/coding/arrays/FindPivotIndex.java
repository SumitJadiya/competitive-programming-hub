package main.com.sumit.coding.arrays;

/**
 * Reference URL : https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
 */
public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println("Pivot Index is - " + (new FindPivotIndex()).pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
