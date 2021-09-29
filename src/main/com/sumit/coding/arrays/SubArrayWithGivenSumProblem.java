package main.com.sumit.coding.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
 *  Subarray with given sum
 *  Problem URL : https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1#
 * */
public class SubArrayWithGivenSumProblem {

    public static void main(String[] args) {
        int N = 5, S = 12;
        int[] arr = {1, 2, 3, 7, 5};
        ArrayList<Integer> result = subarraySum(arr, N, S);
        result.forEach(System.out::println);

        System.out.println();

        N = 10;
        S = 15;
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        result = subarraySum(arr, N, S);
        result.forEach(System.out::println);

        System.out.println();

        N = 42;
        S = 468;
        arr = new int[]{135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        result = subarraySum(arr, N, S);
        result.forEach(System.out::println);
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) {

        int currSum = arr[0];
        int startIndex = 0;

        for (int index = 1; index <= n; index++) {

            while (currSum > sum && startIndex < index - 1) {
                currSum -= arr[startIndex];
                startIndex++;
            }
            if (currSum == sum)
                return new ArrayList<>(Arrays.asList(startIndex + 1, index));

            if (index < n)
                currSum += arr[index];
        }

        return new ArrayList<>();
    }
}
