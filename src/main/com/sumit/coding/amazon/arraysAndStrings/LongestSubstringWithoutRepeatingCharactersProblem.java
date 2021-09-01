package main.com.sumit.coding.amazon.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem URL : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * */
public class LongestSubstringWithoutRepeatingCharactersProblem {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     * */
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j)))
                i = Math.max(map.get(s.charAt(i)), i);

            maxLength = Math.max(maxLength, j - i + 1);
            map.put(s.charAt(j), j + 1);

            if (maxLength + i > n) break;
        }

        return maxLength;
    }
}
