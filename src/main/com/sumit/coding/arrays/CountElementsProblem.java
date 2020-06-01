package main.com.sumit.coding.arrays;

import java.util.Map;
import java.util.TreeMap;

/**
 * Problem URL:
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
