package main.com.sumit.coding.topics.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem URL:
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3288/
 * <p>
 * String[] input = {"sap", "sun", "abs", "bas", "asp", "aps"};
 * [sun]
 * [abs, bas]
 * [sap, asp, aps]
 */
public class GroupAnagram {

    public static void main(String[] args) {
        String[] input = {"sap", "sun", "abs", "bas", "asp", "aps"};
        List<List<String>> list = new GroupAnagram().groupAnagrams(input);

        for (List<String> str : list) {
            System.out.println(str);
        }
    }

    /*
     * Time Complexity : O(N * K * logN)
     * Space Complexity : O(N * K)
     *
     * N -> Length of array input
     * K -> max length of element inside input array
     * */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String newWord = Stream.of(str.split("")).sorted().collect(Collectors.joining());

            map.putIfAbsent(newWord, new ArrayList<>());
            map.get(newWord).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
