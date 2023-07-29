package main.com.sumit.coding.topics.arrays;


/*
Kadane's Algorithm
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Example 1:

Input:
N = 5, arr[] = {1,2,3,-2,5}
Output: 9
Explanation: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.

Example 2:

Input:
N = 4, arr[] = {-1,-2,-3,-4}
Output: -1
Explanation: Max subarray sum is -1 of element (-1)

Time Complexity: O(N)
Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 106
-107 ≤ A[i] ≤ 107
*/
public class KadaneAlgorithm {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        System.out.println(maxSubarraySum(arr, arr.length));
    }

    static int maxSubarraySum(int arr[], int n) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxTillHere = 0;

        for (int i = 0; i < n; i++) {
            maxTillHere += arr[i];

            if (maxSoFar < maxTillHere) maxSoFar = maxTillHere;

            if (maxTillHere < 0) maxTillHere = 0;
        }

        return maxSoFar;
    }
}
