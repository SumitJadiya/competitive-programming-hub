package main.com.sumit.coding.sorting;

import java.util.Arrays;

/*
 * Merge Sorted Array
 * Problem URL : https://leetcode.com/problems/merge-sorted-array/
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6]. The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{0};
        nums2 = new int[]{1};
        m = 0;
        n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        n = n - 1;
        m = m - 1;

        while (len >= 0) {
            if (n < 0) break;

            if (m >= 0 && nums1[m] > nums2[n])
                nums1[len] = nums1[m--];
            else
                nums1[len] = nums2[n--];

            len--;
        }
    }
}
