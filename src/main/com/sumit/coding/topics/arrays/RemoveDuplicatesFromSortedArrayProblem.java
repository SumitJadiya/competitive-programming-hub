package main.com.sumit.coding.topics.arrays;


/*
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * */
public class RemoveDuplicatesFromSortedArrayProblem {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicatesFromSortedArrayProblem().removeDuplicates(nums));
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     * */
    public int removeDuplicates(int[] nums) {
        int currPtr = 1;
        int nextPtr = 1;

        for (int idx = 0; idx < nums.length - 1; idx++) {
            if (nums[idx] == nums[idx + 1])
                nextPtr++;
            else
                nums[currPtr++] = nums[nextPtr++];
        }

        return currPtr;
    }
}
