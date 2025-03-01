package com.sumit.coding.patterns.slidingWindow;

//Find the maximum sum of any subarray of size k.
public class MaxSumOfSubarraySizeK {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 51, 170, 11, 130, 17, 19, 23, 29};
        int k = 3;

        System.out.println(maxSumOfSubarray(array, k));
    }

    private static int maxSumOfSubarray(int[] array, int k) {
        int sum = 0;
        int len = array.length;

        for (int i = 0; i < k; i++)
            sum += array[i];

        int max = sum;
        for (int i = k; i < len; i++) {
            sum = sum + array[i] - array[i - k];
            max = Math.max(max, sum);
        }

        return max;
    }
}
