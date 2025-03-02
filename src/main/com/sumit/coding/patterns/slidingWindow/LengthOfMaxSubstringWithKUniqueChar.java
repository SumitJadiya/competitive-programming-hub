package com.sumit.coding.patterns.slidingWindow;

import java.util.HashMap;
import java.util.Map;

// Given a string s and an integer k, find the length of the longest substring that contains at most k distinct characters.
public class LengthOfMaxSubstringWithKUniqueChar {

    public static void main(String[] args) {
        String str = "eceba";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(str, k));

        str = "aa";
        k = 1;
        System.out.println(lengthOfLongestSubstringKDistinct(str, k));
    }

    private static int lengthOfLongestSubstringKDistinct(String str, int k) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        int left = 0;
        int maxLen = 0;
        int len = str.length();

        for (int right = 0; right < len; right++) {
            char ch = str.charAt(right);
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);

            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(left);

                charFrequencyMap.put(leftChar, charFrequencyMap.getOrDefault(leftChar, 0) - 1);

                if (charFrequencyMap.get(leftChar) == 0)
                    charFrequencyMap.remove(leftChar);

                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}