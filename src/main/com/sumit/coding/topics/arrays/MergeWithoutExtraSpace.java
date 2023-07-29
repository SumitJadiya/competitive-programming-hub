package main.com.sumit.coding.topics.arrays;

import java.util.Arrays;

/*
Problem : Merge Without Extra Space
Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
Merge them in sorted order without using any extra space.
Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

Example 1:
Input: n = 4, arr1[] = [1 3 5 7] , m = 5, arr2[] = [0 2 6 8 9]
Output: arr1[] = [0 1 2 3] arr2[] = [5 6 7 8 9]
Explanation: After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.

Example 2:
Input: n = 2, arr1[] = [10, 12] , m = 3, arr2[] = [5 18 20]
Output: arr1[] = [5 10] arr2[] = [12 18 20]
Explanation: After merging two sorted arrays we get 5 10 12 18 20.

Expected Time Complexity:  O((n+m) log(n+m))
Expected Auxilliary Space: O(1)
*/
public class MergeWithoutExtraSpace {

    public static void main(String[] args) {
        long[] arr1 = {1, 3, 5, 7};
        long[] arr2 = {0, 2, 6, 8, 9};
        merge(arr1, arr2, arr1.length, arr2.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void merge(long[] arr1, long[] arr2, int n, int m) {

        int i = 0;
        int j = 0;
        int k = n - 1;

        // pick the smaller number from second array and add to the end of first array
        while (i <= k && j < m) {
            if (arr1[i] < arr2[j])
                i++;
            else {
                long temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;

                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
