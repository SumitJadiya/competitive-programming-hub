package main.com.sumit.coding.topics.arrays;

/**
 * Reference URL : https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/
 */
public class MinimumSubArrayLength {

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int key = 8;
        System.out.println(new MinimumSubArrayLength().minSubArrayLen(key,arr));
    }

    public int minSubArrayLen(int s, int[] nums) {

        int sum = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            while(sum >= s){
                ans = Math.min(ans, i+1-left);
                sum -= nums[left++];
            }
        }
        return ((ans!=Integer.MAX_VALUE)? ans : 0 );
    }
}
