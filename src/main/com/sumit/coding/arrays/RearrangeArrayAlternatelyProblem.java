package main.com.sumit.coding.arrays;

import java.util.Arrays;

/*
Rearrange Array Alternately
Given a sorted array of positive integers. Your task is to rearrange the array elements alternatively i.e first element
should be max value, second should be min value, third should be second max, fourth should be second min and so on.

Example 1:
Input: N = 6, arr[] = {1,2,3,4,5,6}
Output: 6 1 5 2 4 3
Explanation: Max element = 6, min = 1, second max = 5, second min = 2, and so on... Modified array is : 6 1 5 2 4 3.

Example 2:
Input: N = 11, arr[]={10,20,30,40,50,60,70,80,90,100,110}
Output:110 10 100 20 90 30 80 40 70 50 60
Explanation: Max element = 110, min = 10, second max = 100, second min = 20, and so on... Modified array is : 110 10 100 20 90 30 80 40 70 50 60.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 107
1 <= arr[i] <= 107
*/
public class RearrangeArrayAlternatelyProblem {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        rearrange(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int[] arr, int n) {

        int maxElement = arr[n - 1] + 1;
        int max = n - 1;
        int min = 0;

        // formula -> arr[i] += (arr[min/max] % max_element) * max_element
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                arr[i] += (arr[max--] % maxElement) * maxElement;
            else
                arr[i] += (arr[min++] % maxElement) * maxElement;
        }

        for (int i = 0; i < n; i++)
            arr[i] /= maxElement;
    }
}
