package main.com.sumit.coding.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Problem URL:
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3288/
 */
public class GroupAnagram {

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = new GroupAnagram().groupAnagrams(input);

        for (List<String> str : list) {
            System.out.println(str);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);

            if (map.containsKey(newWord)) {
                map.get(newWord).add(word);
            } else {
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(newWord, words);
            }
        }

        for (String s : map.keySet()) {
            list.add(map.get(s));
        }
        return list;
    }
}
