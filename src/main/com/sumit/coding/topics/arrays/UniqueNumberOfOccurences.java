package main.com.sumit.coding.topics.arrays;

import java.util.HashMap;
import java.util.HashSet;

/*
 * Unique Number of Occurrences
 * Problem URL : https://leetcode.com/problems/unique-number-of-occurrences/
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 *
 * */
public class UniqueNumberOfOccurences {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(new UniqueNumberOfOccurences().uniqueOccurrences(arr));
    }

    private boolean uniqueOccurrences(int[] arr) {
        var map = new HashMap<Integer, Integer>();

        for (int j : arr)
            map.put(j, map.getOrDefault(j, 0) + 1);

        return map.size() == new HashSet<>(map.values()).size();
    }
}
