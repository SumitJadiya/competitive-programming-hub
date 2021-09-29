package main.com.sumit.coding.google.treeAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

/*
    Problem URL : https://leetcode.com/problems/word-ladder/
*/
public class WordLadderProblem {

    private int mainLevel;
    private Map<String, List<String>> mainMap;

    WordLadderProblem() {
        this.mainLevel = 0;
        this.mainMap = new HashMap<>();
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new WordLadderProblem().ladderLength(beginWord, endWord, wordList));
    }

    private int visitWordNode(Queue<Pair<String, Integer>> queue, Map<String, Integer> visited, Map<String, Integer> othersVisited) {

        Pair<String, Integer> node = queue.remove();
        String word = node.getKey();
        int level = node.getValue();

        for (int i = 0; i < this.mainLevel; i++) {

            // Intermediate words for current word
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, mainLevel);

            for (String adjacentWord : mainMap.getOrDefault(newWord, new ArrayList<>())) {
                // If at any point if we find what we are looking for i.e. the end word - we can return with the answer.
                if (othersVisited.containsKey(adjacentWord))
                    return level + othersVisited.get(adjacentWord);

                if (!visited.containsKey(adjacentWord)) {
                    // Save the level as the value of the dictionary, to save number of hops.
                    visited.put(adjacentWord, level + 1);
                    queue.add(new Pair(adjacentWord, level + 1));
                }
            }
        }
        return -1;
    }

    /*
        Time Complexity: O(M2×N) where M is the length of words and N is the total number of words in the input word list.
        Similar to one directional, bidirectional also takes O(M2×N) time for finding out all the transformations.
        But the search time reduces to half, since the two parallel searches meet somewhere in the middle.

        Space Complexity: O(M2×N), to store all M transformations for each of the NN words in the all_combo_dict dictionary, same as one directional.
        But bidirectional reduces the search space. It narrows down because of meeting in the middle.
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        // Since all words are of same length.
        this.mainLevel = beginWord.length();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < mainLevel; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, mainLevel);
                        List<String> transformations =
                                mainMap.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        mainMap.put(newWord, transformations);
                    }
                });

        // Queues for birdirectional BFS
        // BFS starting from beginWord
        Queue<Pair<String, Integer>> Q_begin = new LinkedList<>();
        // BFS starting from endWord
        Queue<Pair<String, Integer>> Q_end = new LinkedList<>();
        Q_begin.add(new Pair(beginWord, 1));
        Q_end.add(new Pair(endWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Integer> visitedBegin = new HashMap<>();
        Map<String, Integer> visitedEnd = new HashMap<>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);

        while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

            // One hop from begin word
            int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
            if (ans > -1) return ans;

            // One hop from end word
            ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
            if (ans > -1) return ans;
        }
        return 0;
    }
}
