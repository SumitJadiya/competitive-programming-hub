package com.sumit.coding.topics.graph;

import java.util.*;

public class WordLadderProblem {

    private static final char[] ALPHABETS = new char[26];

    static {
        for (int i = 0; i < 26; i++)
            ALPHABETS[i] = (char) (i + 'A');
    }

    public static int wordLadder(String begin, String end, List<String> wordList) {
        if (begin.equals(end)) return 0;

        Set<String> unvisitedWords = new HashSet<>(wordList);
        if (!unvisitedWords.contains(end)) return -1;

        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(begin);
        unvisitedWords.remove(begin);

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            step++;

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNeighbors(word, unvisitedWords)) {
                    if (nextWord.equals(end)) return step;

                    queue.add(nextWord);
                }
            }

        }

        return -1;
    }

    private static List<String> getNeighbors(String word, Set<String> unvisitedWords) {
        List<String> unvisitedNeighbors = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            for (char ch : ALPHABETS) {
                String nextWord =
                        word.substring(0, i)
                                + ch
                                + word.substring(i + 1);

                if (unvisitedWords.contains(nextWord)) {
                    unvisitedNeighbors.add(nextWord);
                    unvisitedWords.remove(nextWord);
                }
            }
        }

        return unvisitedNeighbors;
    }

    public static void main(String[] args) {
        String begin = "COLD";
        String end = "WARM";
        List<String> wordList = List.of("COLD", "GOLD", "CORD", "SOLD", "CARD", "WARD", "WARM", "TARD");
        int res = wordLadder(begin, end, wordList);
        System.out.println(res);
    }
}
