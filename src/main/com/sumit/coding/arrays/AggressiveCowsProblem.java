package main.com.sumit.coding.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Aggressive Cows
 * Problem URL : https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559
 *
 * i/p - 6 4
 * o/p - 0 3 4 7 10 9
 * */
public class AggressiveCowsProblem {

    public static void main(String[] args) {
        ArrayList<Integer> stalls = new ArrayList<>(List.of(0, 3, 4, 7, 10, 9));
        System.out.println(aggressiveCows(stalls, 4));
    }

    public static int aggressiveCows(ArrayList<Integer> stalls, int k) {

        Integer max = stalls.stream().max(Integer::compare).get();

        int ans = -1;

        int start = 0;
        int end = max;
        int mid = start + (end - start) / 2;

        Collections.sort(stalls);

        while (start <= end) {
            if (isPossible(stalls, k, mid)) {
                ans = mid;
                start = mid + 1;
            } else
                end = mid - 1;

            mid = start + (end - start) / 2;
        }
        return ans;
    }

    private static boolean isPossible(ArrayList<Integer> stalls, int k, int mid) {
        int cowCount = 1;
        int lastPos = stalls.get(0);

        for (Integer stall : stalls) {
            if (stall - lastPos >= mid) {
                cowCount++;
                if (cowCount == k) {
                    return true;
                }

                lastPos = stall;
            }
        }
        return false;
    }
}
