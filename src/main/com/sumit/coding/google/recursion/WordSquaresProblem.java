package main.com.sumit.coding.google.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array of unique strings words, return all the word squares you can build from words.
 * The same word from words can be used multiple times. You can return the answer in any order.
 *
 * A sequence of strings forms a valid word square if the kth row and column read the same string, where 0 <= k < max(numRows, numColumns).
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
 *
 * Input: words = ["area","lead","wall","lady","ball"]
 * Output: [["ball","area","lead","lady"],["wall","area","lead","lady"]]
 * Explanation: The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 * */
public class WordSquaresProblem {

    int len = 0;
    String[] words = null;
    HashMap<String, List<String>> prefixHashMap = null;

    /*
     * Time Complexity : O(N*26^L)
     * Space Complexity : O(N.L)
     * where N is the number of words and L is the length of a single word.
     * */
    public List<List<String>> wordSquares(String[] words) {
        this.words = words;
        this.len = words[0].length();
        List<List<String>> results = new ArrayList<>();

        this.buildPrefixHashTable(words);

        for (String word : words) {
            LinkedList<String> wordSquare = new LinkedList<>();
            wordSquare.addLast(word);
            backtracking(1, wordSquare, results);
        }

        return results;
    }

    private void backtracking(int step, LinkedList<String> wordSquare, List<List<String>> results) {
        // base case
        if (step == len) {
            results.add((List<String>) wordSquare.clone());
            return;
        }

        StringBuilder prefix = new StringBuilder();

        for (String word : wordSquare)
            prefix.append(word.charAt(step));

        for (String candidate : getStringWithPrefix(prefix.toString())) {
            wordSquare.addLast(candidate);
            backtracking(step + 1, wordSquare, results);
            wordSquare.removeLast();
        }
    }

    private void buildPrefixHashTable(String[] words) {
        prefixHashMap = new HashMap<>();

        for (String word : words) {
            for (int i = 1; i < len; i++) {
                String prefix = word.substring(0, i);
                prefixHashMap.putIfAbsent(prefix, new ArrayList<>());
                List<String> wordList = prefixHashMap.get(prefix);
                wordList.add(word);
            }
        }
    }

    private List<String> getStringWithPrefix(String prefix) {
        List<String> wordList = prefixHashMap.get(prefix);
        return (wordList != null) ? wordList : new ArrayList<>();
    }

    public static void main(String[] args) {
        String[] words = {"area", "lead", "wall", "lady", "ball"};
        System.out.println(new WordSquaresProblem().wordSquares(words));
    }
}
