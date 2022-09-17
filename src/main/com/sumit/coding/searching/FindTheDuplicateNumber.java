package main.com.sumit.coding.searching;

/*
 * Find the Duplicate Number
 * Problem URL : https://leetcode.com/problems/find-the-duplicate-number/
 *
 * i/p : [2,2,2,2,2] o/p : 2
 * i/p : [3,1,3,4,2] o/p : 3
 * */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(findDuplicate_usingCycleDetection(nums));
        System.out.println(findDuplicate_usingArrayModification(nums));
        System.out.println(findDuplicate_usingBinarySearch(nums));

        nums = new int[]{3, 1, 3, 4, 2};
        System.out.println(findDuplicate_usingCycleDetection(nums));
        System.out.println(findDuplicate_usingArrayModification(nums));
        System.out.println(findDuplicate_usingBinarySearch(nums));
    }

    /*
     * Time Complexity : O(nlogN)
     * O(logN) due to binary search and O(N) due to the loop inside binary search
     * */
    private static int findDuplicate_usingBinarySearch(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int duplicate = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int count = 0;
            for (int num : nums)
                if (num <= mid) count++;

            if (count > mid) {
                duplicate = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }

        return duplicate;
    }

    /*
     * Time Complexity : O(n)
     * */
    private static int findDuplicate_usingArrayModification(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int nxt = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = nxt;
        }
        return nums[0];
    }

    /*
     * Time Complexity : O(n)
     * */
    private static int findDuplicate_usingCycleDetection(int[] nums) {

        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}
