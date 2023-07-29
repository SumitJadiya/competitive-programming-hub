package main.com.sumit.coding.companies.google.arraysAndStrings;

import java.util.PriorityQueue;

/*
 * Problem URL : https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * */
public class KthLargestElementInArrayProblem {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest_approach1(nums, k));
        System.out.println(findKthLargest_approach1(nums, k));
    }

    /*
     * Time Complexity : O(nlogk)
     * Space Complexity : O(k)
     * */
    public static int findKthLargest_approach1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        for (int n : nums) {
            heap.add(n);

            if (heap.size() > k)
                heap.poll();
        }

        return (!heap.isEmpty()) ? heap.poll() : -1;
    }
}
