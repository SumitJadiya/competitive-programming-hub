package main.com.sumit.coding.topics.strings;

/*
 * URL : https://leetcode.com/problems/longest-palindromic-substring/
 * */
public class LongestPalindromeSubstringProblem {

    int resultStart;
    int resultLength;

    public static void main(String[] args) {
        String s = "babad";

        LongestPalindromeSubstringProblem longestPalindromeSubstringProblem = new LongestPalindromeSubstringProblem();
        System.out.println(longestPalindromeSubstringProblem.longestPalindrome(s));
        System.out.println(longestPalindromeSubstringProblem.longestPalindrome_dp(s));
    }

    public String longestPalindrome(String s) {
        int strLength = s.length();
        if (strLength < 2)
            return s;

        for (int start = 0; start < strLength - 1; start++) {
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private void expandRange(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }

    public String longestPalindrome_dp(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[]{0, 0};

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans[0] = i;
                ans[1] = i + 1;
            }
        }

        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        int i = ans[0];
        int j = ans[1];
        return s.substring(i, j + 1);
    }
}
