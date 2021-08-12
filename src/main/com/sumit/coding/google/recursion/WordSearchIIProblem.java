package main.com.sumit.coding.google.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Problem URL : https://leetcode.com/problems/word-search-ii/
 * */
public class WordSearchIIProblem {

    char[][] board = null;
    ArrayList<String> result = new ArrayList<>();
    int[] rowOffset = {-1, 0, 1, 0};
    int[] colOffset = {0, 1, 0, -1};

    public List<String> findWords(char[][] board, String[] words) {

        // 1. construct trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                if (node.child.containsKey(letter))
                    node = node.child.get(letter);
                else {
                    TrieNode newNode = new TrieNode();
                    node.child.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }

        this.board = board;

        //2. backtracking for each cell in the board
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                if (root.child.containsKey(board[row][col]))
                    backtrack(row, col, root);
            }
        }

        return result;
    }

    private void backtrack(int row, int col, TrieNode parent) {
        Character letter = this.board[row][col];
        TrieNode currNode = parent.child.get(letter);

        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }

        this.board[row][col] = '#';

        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this.board.length || newCol < 0 || newCol >= this.board[0].length) continue;

            if (currNode.child.containsKey(this.board[newRow][newCol]))
                backtrack(newRow, newCol, currNode);
        }

        board[row][col] = letter;

        if (currNode.child.isEmpty())
            parent.child.remove(letter);
    }

    public static void main(String[] args) {

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(new WordSearchIIProblem().findWords(board, words));
    }
}

class TrieNode {
    HashMap<Character, TrieNode> child = new HashMap<>();
    String word = null;

    public TrieNode() {
    }
}
