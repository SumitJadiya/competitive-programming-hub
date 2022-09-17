package main.com.sumit.coding.searching;

/*
 * Fixed Point
 * Problem URL : https://leetcode.com/problems/fixed-point/
 *
 * Given an array of distinct integers' arr, where arr is sorted in ascending order, return the smallest index i that satisfies arr[i] == i. If there is no such index, return -1.
 *
 * Input: arr = [0,2,5,8,17] Output: 0
 * Explanation: arr[0] = 0, thus the output is 0.
 *
 * Input: arr = [-10,-5,3,4,7,9] Output: -1
 * Explanation: There is no such i that arr[i] == i, thus the output is -1.
 * */
public class FixedPointProblem {

    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 8, 17};
        System.out.println(fixedPoint(arr));
    }

    public static int fixedPoint(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;
        int ans = -1;

        while (start <= end) {
            if (arr[mid] == mid) {
                ans = mid;
                end = mid - 1;
            } else if (mid < arr[mid]) end = mid - 1;
            else start = mid + 1;

            mid = start + (end - start) / 2;
        }

        return ans;
    }
}
