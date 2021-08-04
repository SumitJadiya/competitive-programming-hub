package main.com.sumit.coding.google.arraysAndStrings;

/*
 * Problem URL : https://leetcode.com/problems/minimum-window-substring/
 *
 * Input: s = "ADOBECODEBANC", t = "ABC", Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * */
public class MinimumWindowSubstringProblem {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(new MinimumWindowSubstringProblem().minWindow(s, t));
    }

    /*
     * Time Complexity : O(s+t)
     * Space Complexity : O(s+t)
     * */
    public String minWindow(String s, String t) {
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        return minWindowSubstring(first, second);
    }

    private String minWindowSubstring(char[] first, char[] second) {
        int[] map = new int[256];

        int ans = Integer.MAX_VALUE;
        int start = 0, count = 0;

        for (char c : second) {
            if (map[c] == 0) count++;
            map[c]++;
        }

        int i = 0, j = 0;

        while (j < first.length) {
            map[first[j]]--;
            if (map[first[j]] == 0) count--;

            if (count == 0) {
                while (count == 0) {
                    if (ans > j - i + 1) {
                        ans = Math.min(ans, j - i + 1);
                        start = i;
                    }

                    map[first[i]]++;

                    if (map[first[i]] > 0) count++;
                    i++;
                }
            }
            j++;
        }

        if (ans != Integer.MAX_VALUE) return String.valueOf(first).substring(start, ans + start);

        return "";
    }
}
