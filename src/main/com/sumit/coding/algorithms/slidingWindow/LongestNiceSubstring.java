package main.com.sumit.coding.algorithms.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/*Ø
 * URL - https://leetcode.com/problems/longest-nice-substring/
 *
 * Input: s = "YazaAay"
 * Output: "aAa"
 * Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, & both 'A' & 'a' appear. "aAa" is the longest nice substring.
 * */
public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        int[] niceSubstring = longestNiceSubstring(s, 0, s.length() - 1);
        return s.substring(niceSubstring[0], niceSubstring[1] + 1);
    }

    private int[] longestNiceSubstring(String s, int left, int right) {
        int splittingIndex = isNotNiceString(s, left, right);
        if (splittingIndex == -1) return new int[]{left, right};
        int[] leftString = longestNiceSubstring(s, left, splittingIndex - 1);
        int[] rightString = longestNiceSubstring(s, splittingIndex + 1, right);
        return (leftString[1] - leftString[0] >= rightString[1] - rightString[0]) ? leftString : rightString;
    }

    private int isNotNiceString(String s, int left, int right) {
        Set<Character> set = getCharacterSet(s, left, right);
        for (int i = left; i <= right; i++) {
            char ch = s.charAt(i);
            if (!set.contains(Character.toLowerCase(ch)) || !set.contains(Character.toUpperCase(ch))) {
                return i;
            }
        }
        return -1;
    }

    private Set<Character> getCharacterSet(String s, int left, int right) {
        Set<Character> charSet = new HashSet<>();
        for (int i = left; i <= right; i++) {
            charSet.add(s.charAt(i));
        }
        return charSet;
    }

    public static void main(String[] args) {
        System.out.println(new LongestNiceSubstring().longestNiceSubstring("YazaAay"));
    }
}
