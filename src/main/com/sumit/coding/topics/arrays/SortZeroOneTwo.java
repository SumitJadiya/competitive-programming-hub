package main.com.sumit.coding.topics.arrays;

import java.util.Arrays;

/*
 * Sort 0 1 2
 * Problem URL : https://www.codingninjas.com/codestudio/problems/sort-0-1-2_631055
 * I/P : 0 1 2 2 1 0
 * O/P : 0 0 1 1 2 2-
 * */
public class SortZeroOneTwo {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1, 2, 1, 2};
        System.out.println(Arrays.toString(sort012(arr)));
    }

    /*
     * Time Complexity: O(N)
     * */
    public static int[] sort012(int[] arr) {
        int left = 0;
        int mid = 0;
        int right = arr.length - 1;

        while (mid <= right) {

            if (arr[mid] == 0) {
                swap(arr, mid, left);
                mid += 1;
                left += 1;
            } else if (arr[mid] == 2) {
                swap(arr, mid, right);
                right -= 1;
            } else {
                mid += 1;
            }
        }

        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
        }
    }
}
