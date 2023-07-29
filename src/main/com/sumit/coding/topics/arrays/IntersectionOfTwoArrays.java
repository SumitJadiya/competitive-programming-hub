package main.com.sumit.coding.topics.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Intersection of Two Arrays
 * Problem URL : https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 * */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(nums1, nums2)));
    }

    /*
     * Time Complexity : O(N + M)
     * N = length of nums1
     * M = length of nums2
     * */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int j : nums1) set.add(j);

        for (int j : nums2)
            if (set.contains(j))
                intersect.add(j);

        return intersect.stream().mapToInt(Integer::intValue).toArray();
    }
}
