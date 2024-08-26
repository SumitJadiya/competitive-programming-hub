package com.sumit.coding.topics.trie.basicOperations;

/**
 * Class that resembles trie data structure
 */
public class Trie {
    final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }


    /**
     * @param word
     * @return
     */
    public boolean query(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.getChild().get(ch);
            if (node == null)
                return false;
        }
        return node.isEndOfWord();
    }

    /**
     * @param word
     */
    public void insert(final String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.getChild().putIfAbsent(ch, new TrieNode());
            node = node.getChild().get(ch);
        }

        node.setEndOfWord(true);
    }

    /**
     * method that deletes the String from trie Data Structure
     *
     * @param word Input String
     */
    public void delete(final String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            if (node == null)
                return;

            node = node.getChild().get(ch);
        }
        if (node.isEndOfWord())
            node.setEndOfWord(false);
        else
            throw new RuntimeException("String doesn't Exist");
    }

    /**
     * Method to perform update operation
     *
     * @param oldString old String that we want to replace
     * @param newString new String
     */
    public void update(final String oldString, final String newString) {
        delete(oldString);
        insert(newString);
    }
}
