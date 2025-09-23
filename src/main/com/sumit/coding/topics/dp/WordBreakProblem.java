package com.sumit.coding.topics.dp;

import java.util.Arrays;
import java.util.List;

public class WordBreakProblem {
    public static boolean wordBreak(String s, List<String> words) {

        return dfs(0, new Boolean[s.length()], s, words);
    }

    public static boolean dfs(int startIdx, Boolean[] memo, String target, List<String> words) {
        if (startIdx == target.length())
            return true;

        if (memo[startIdx] != null) return memo[startIdx];

        boolean ans = false;

        for (String word : words)
            if (target.substring(startIdx).startsWith(word))
                ans = ans || (dfs(startIdx + word.length(), memo, target, words));

        memo[startIdx] = ans;
        return ans;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        String s = "abcd";
        List<String> words = splitWords("a abc b cd");

        boolean res = wordBreak(s, words);
        System.out.println(res);
    }
}
