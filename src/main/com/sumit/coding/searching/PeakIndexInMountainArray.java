package main.com.sumit.coding.searching;

/*
 * Peak Index in a Mountain Array
 * Problem URL : https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *
 * i/p: arr = [0,10,5,2]
 * o/p: 1
 * */
public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
        System.out.println(peakIndexInMountainArray(arr));
    }

    /*
     * Time Complexity: O(N) where N = length of array
     * */
    private static int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;

        while (start < end) {
            if (arr[mid] < arr[mid + 1]) start = mid + 1;
            else end = mid;

            mid = start + (end - start) / 2;
        }

        return start;
    }
}
