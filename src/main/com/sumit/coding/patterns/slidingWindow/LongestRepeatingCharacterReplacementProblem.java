package com.sumit.coding.patterns.slidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * Statement
 * Given a string s and an integer k, find the length of the longest substring in s,
 * where all characters are identical, after replacing, at most, k characters with any other lowercase English character.
 * Constraints:
 * - 1≤ s.length ≤10^3
 * - s consists of only lowercase English characters
 * - 0 ≤ k ≤ s.length

 * */
public class LongestRepeatingCharacterReplacementProblem {

    public static void main(String[] args) {
        String input = "aaacbbbaabab";
        int k = 2;
        System.out.println(longestRepeatingCharacterReplacement(input, k));
    }

    public static int longestRepeatingCharacterReplacement(String input, int k) {
        int length = input.length();
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int windowLength;
        int maxFrequency = 0;

        for (int right = 0; right < length; right++) {
            char rightChar = input.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            windowLength = right - left + 1;
            maxFrequency = Collections.max(map.values());

            while ((windowLength - maxFrequency) > k) {
                char leftChar = input.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) map.remove(leftChar);
                left++;
                windowLength = right - left + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
