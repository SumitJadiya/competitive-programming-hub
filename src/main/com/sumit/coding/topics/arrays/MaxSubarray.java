package main.com.sumit.coding.topics.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 *  Using Array :
 *  Input : [1, -2, 0, 3]
 *  output : 3
 *
 *  Input : [3, -1, -1, 4, 3, -1]
 *  output : 8
 *
 *  Input : [-2, 5, -1, 7, -3]
 *  Output : 11
 *
 *  Using ArrayList :
 *  https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 *
 */

public class MaxSubarray {
    public static void main(String[] args) {

        int[] arr = {1, -2, 0, 3};
        int result = maxSubarraySum(arr);
        System.out.println("Max Subarray Sum is = " + result);

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(-1);
        list.add(2);
        list.add(1);
        System.out.println("Max Subarray Sum of ArrayList is = " + maxSubArray(list));
    }

    private static int maxSubarraySum(int[] arr) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int value : arr) {
            sum += value;

            if (sum > max)
                max = sum;

            if (sum < 0)
                sum = 0;
        }

        return max;
    }

    private static int maxSubArray(final List<Integer> A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int value : A) {
            sum += value;

            if (sum > max)
                max = sum;

            if (sum < 0)
                sum = 0;
        }

        return max;
    }

}
