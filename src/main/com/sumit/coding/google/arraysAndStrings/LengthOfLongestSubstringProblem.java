package main.com.sumit.coding.google.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem URL : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * */
public class LengthOfLongestSubstringProblem {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(min(m,n))
     * */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j)))
                i = Math.max(map.get(s.charAt(j)), i);

            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);

            if (ans + i > n) break;
        }
        return ans;
    }
}
