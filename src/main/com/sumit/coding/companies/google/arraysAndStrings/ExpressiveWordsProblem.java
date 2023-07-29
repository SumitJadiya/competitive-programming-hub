package main.com.sumit.coding.companies.google.arraysAndStrings;

/*
 * Problem URL : https://leetcode.com/problems/expressive-words
 *
 * Input: s = "heeellooo", words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation:
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 * */
public class ExpressiveWordsProblem {

    public static void main(String[] args) {
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        System.out.println(new ExpressiveWordsProblem().expressiveWords(s, words));
    }

    /*
     * Time Complexity : O(M+N)
     * Space Complexity : O(N)
     * */
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words)
            if (is(word, s)) count++;
        return count;
    }

    private boolean is(String currentWord, String targetWord) {

        int i = 0, j = 0;

        while (i < targetWord.length() && j < currentWord.length()) {
            if (targetWord.charAt(i) == currentWord.charAt(j)) {
                int currentCount = 1;
                int targetCount = 1;

                while (i + 1 < targetWord.length() && targetWord.charAt(i) == targetWord.charAt(i + 1)) {
                    targetCount++;
                    i++;
                }

                while (j + 1 < currentWord.length() && currentWord.charAt(j) == currentWord.charAt(j + 1)) {
                    currentCount++;
                    j++;
                }

                if (targetCount < currentCount || (currentCount != targetCount && targetCount <= 2))
                    return false;

                i++;
                j++;
            } else
                return false;

        }
        return j == currentWord.length() && i == targetWord.length();
    }
}
