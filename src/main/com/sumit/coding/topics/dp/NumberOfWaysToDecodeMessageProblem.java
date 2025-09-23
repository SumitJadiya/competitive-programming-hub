package com.sumit.coding.topics.dp;

import java.util.Arrays;

public class NumberOfWaysToDecodeMessageProblem {


    public static int decodeWays(String digits) {
        int[] memo = new int[digits.length()];
        Arrays.fill(memo, -1);
        return dfs(0, memo, digits);
    }

    public static int dfs(int startIdx, int[] memo, String digits) {
        if (startIdx == digits.length()) return 1;

        if (memo[startIdx] != -1) return memo[startIdx];

        int ways = 0;

        if (digits.charAt(startIdx) == '0') return ways;

        ways += dfs(startIdx + 1, memo, digits);

        if (startIdx + 2 <= digits.length() && Integer.parseInt(digits.substring(startIdx, startIdx + 2)) <= 26)
            ways += dfs(startIdx + 2, memo, digits);

        memo[startIdx] = ways;

        return ways;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();

        String digits = "19908";
        int res = decodeWays(digits);
        System.out.println(res);
        long end = System.nanoTime();

        System.out.println(end - start);
    }
}
