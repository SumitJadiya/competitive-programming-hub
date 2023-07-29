package main.com.sumit.coding.topics.strings;

/*
 * Permutation in String
 * Problem URL : https://leetcode.com/problems/permutation-in-string/
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * */
public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    /*
     * Time Complexity : O(N) where N is max of s1, s2
     * */
    public static boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        int windowLen = s1.length();

        for (int i = s1.length() - 1; i >= 0; i--)
            count[s1.charAt(i) - 'a']++;

        int i = 0;
        while (i < windowLen && i < s2.length()) {
            count[s2.charAt(i) - 'a']--;
            i++;
        }

        if (checkEqual(count)) return true;

        while (i < s2.length()) {
            int newChar = s2.charAt(i);
            count[newChar - 'a']--;

            int oldChar = s2.charAt(i - windowLen);
            count[oldChar - 'a']++;

            if (checkEqual(count)) return true;

            i++;
        }

        return false;
    }

    private static boolean checkEqual(int[] count) {
        int i = 0;
        while (i < 26) {
            if (count[i] != 0) return false;
            i++;
        }

        return true;
    }
}
