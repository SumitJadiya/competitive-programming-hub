package main.com.sumit.coding.algorithms.searching;

import java.util.ArrayList;
import java.util.List;

/*
 * Allocate Books
 * Problem URL: https://www.codingninjas.com/codestudio/problems/allocate-books_1090540
 *
 * I/P : 4 2
 * 12 34 67 90
 *
 * O/P : 113
 * */
public class AllocateBooksProblem {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(12, 34, 67, 90));
        int totalSize = 4;
        int totalStudentCount = 2;

        System.out.println(allocateBooks(arr, totalSize, totalStudentCount));
    }

    /*
     * Time Complexity : O(logN), where N = sum of arraylist
     * Space Complexity : O(N)
     * */
    public static int allocateBooks(ArrayList<Integer> arr, int totalSize, int totalStudentCount) {
        int start = 0;
        int end = arr.stream().reduce(0, Integer::sum);
        int ans = 0;

        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (isPossible(arr, totalSize, totalStudentCount, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            mid = start + (end - start) / 2;
        }
        return ans;
    }

    private static boolean isPossible(ArrayList<Integer> arr, int totalSize, int totalStudentCount, int mid) {
        int studentCount = 1;
        int pageSum = 0;

        for (int i = 0; i < totalSize; i++) {
            if (pageSum + arr.get(i) <= mid) pageSum += arr.get(i);
            else {
                studentCount++;
                if (studentCount > totalStudentCount || arr.get(i) > mid) return false;

                pageSum = arr.get(i);
            }
        }
        return true;
    }
}
