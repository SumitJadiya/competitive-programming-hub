package main.com.sumit.coding.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * First and Last Position of an Element In Sorted Array
 * Problem URL : https://www.codingninjas.com/codestudio/problems/first-and-last-position-of-an-element-in-sorted-array_1082549
 *
 * i/p : 2
 *       0 0 1 1 2 2 2 2
 * o/p : 4 7
 * */
public class FirstAndLastPositionOfElementInSortedArrayProblem {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(0, 0, 1, 1, 2, 2, 2, 2));
        int k = 2;
        System.out.println(Arrays.toString(firstAndLastPosition(arr, arr.size(), k)));
    }

    /*
     * Time Complexity : O(logN + logN) ~ O(logN)
     * */
    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(findOccurance(arr.stream().mapToInt(Integer::intValue).toArray(), n, k, "FIRST"));
        result.add(findOccurance(arr.stream().mapToInt(Integer::intValue).toArray(), n, k, "LAST"));

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int findOccurance(int[] arr, int n, int k, String occurance) {
        int start = 0, end = n - 1;
        int ans = -1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (arr[mid] == k && occurance.equals("FIRST")) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] == k && occurance.equals("LAST")) {
                ans = mid;
                start = mid + 1;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = start + (end - start) / 2;
        }

        return ans;
    }
}
