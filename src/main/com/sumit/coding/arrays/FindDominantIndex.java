package main.com.sumit.coding.arrays;

/**
 * Reference URL: https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
 */
public class FindDominantIndex {

    public static void main(String[] args) {
        int arr[] = {1,0};
        System.out.println(new FindDominantIndex().dominantIndex(arr));
    }

    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i=0; i< nums.length;i++){
            if(nums[i]>max) {
                max = nums[i];
                index = i;
            }
        }

        for (int i:nums){
            if(i!= max && (max<2*i))
                index = -1;
        }

        return index;
    }
}
