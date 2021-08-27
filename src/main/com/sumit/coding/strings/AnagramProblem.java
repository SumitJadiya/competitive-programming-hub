package main.com.sumit.coding.strings;

/*
 * Problem URL : https://leetcode.com/problems/valid-anagram/
 * */
public class AnagramProblem {

    public static void main(String[] args) {
        final String string1 = "geeksforgeeks";
        final String string2 = "forgeeksgeeks";

        boolean result = AnagramProblem.checkForAnagram(string1, string2);
        System.out.println(result);
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * */
    private static boolean checkForAnagram(String string1, String string2) {
        if (string1.length() != string2.length())
            return false;

        int[] counter = new int[26];

        for (int i = 0; i < string1.length(); i++) {
            counter[string1.charAt(i) - 'a']++;
            counter[string2.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0)
                return false;
        }

        return true;
    }
}
