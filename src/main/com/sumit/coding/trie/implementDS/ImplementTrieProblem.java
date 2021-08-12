package main.com.sumit.coding.trie.implementDS;

/*
 * Problem URL : https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 *
 * Output :[null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * */
public class ImplementTrieProblem {

    public static void main(String[] args) {
        String word = "apple";
        String prefix = "app";

        Trie obj = new Trie();
        obj.insert(word);
        boolean param_1 = obj.search(word);
        System.out.println(param_1);

        boolean param_2 = obj.search(word);
        System.out.println(param_2);

        boolean param_3 = obj.startsWith(prefix);
        System.out.println(param_3);
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (!node.containsKey(currentChar))
                node.put(currentChar, new TrieNode());

            node = node.get(currentChar);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);

            if (node != null && node.containsKey(curLetter))
                node = node.get(curLetter);
            else
                node = null;
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}


class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
