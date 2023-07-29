package main.com.sumit.coding.algorithms.searching;

import java.util.ArrayList;
import java.util.List;

/*
 * Painter's Partition Problem
 * Problem URL : https://www.codingninjas.com/codestudio/problems/painter-s-partition-problem_1089557
 *
 * i/p : 48 90
 * o/p : 90
 *
 * Note - similar to AllocateBooksProblem
 * */
public class PaintersProblem {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(48, 90));
        int totalPainterCount = 2;

        System.out.println(findLargestMinDistance(arr, totalPainterCount));
    }

    private static int findLargestMinDistance(ArrayList<Integer> boards, int k) {

        int len = boards.size();
        int ans = 0;

        int start = 0;
        int end = boards.stream().reduce(0, Integer::sum);
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (isPossibleSolution(boards, len, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            mid = start + (end - start) / 2;
        }
        return ans;
    }

    private static boolean isPossibleSolution(ArrayList<Integer> boards, int len, int k, int mid) {

        int painterCount = 1;
        int paintSum = 0;

        for (int i = 0; i < len; i++) {
            if ((boards.get(i) + paintSum) <= mid) paintSum += boards.get(i);
            else {
                painterCount++;
                if (painterCount > k || boards.get(i) > mid) return false;

                paintSum = boards.get(i);
            }
        }

        return true;
    }
}
