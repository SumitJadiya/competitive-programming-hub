package main.com.sumit.coding.trie.basicOperations;

/**
 * TrieNode
 */
public class TrieNode {
    final TrieNode[] trieNodes = new TrieNode[26];
    int terminating;

    /**
     * @param c input character
     * @return trienode
     */
    public TrieNode next(final char c) {
        return trieNodes[c - 'a'];
    }
}
