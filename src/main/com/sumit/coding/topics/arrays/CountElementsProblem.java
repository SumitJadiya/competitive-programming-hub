package main.com.sumit.coding.topics.arrays;

import java.util.Map;
import java.util.TreeMap;

/**
 * Problem URL:
 * Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr.
 * If there are duplicates in arr, count them separately.
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/
 */
public class CountElementsProblem {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 5, 0};
        int count = new CountElementsProblem().countElements(arr);
        System.out.println(count);
    }

    public int countElements(int[] arr) {

        int count = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int value : arr) {
            if (map.containsKey(value))
                map.put(value, map.get(value) + 1);
            else
                map.put(value, 1);
        }

        for (int s : map.keySet()) {
            if (map.containsKey(s + 1))
                count += map.get(s);
        }
        return count;
    }
}
