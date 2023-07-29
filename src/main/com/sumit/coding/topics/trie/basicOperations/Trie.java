package main.com.sumit.coding.topics.trie.basicOperations;

/**
 * Class that resembles trie data structure
 */
public class Trie {
    final TrieNode root;

    /**
     * Constructor
     */
    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * method to perform searching operations using trie
     * @param s input string
     * @return frequency of string in trie data structure
     */
    public int query(String s) {
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            if (current == null)
                return 0;

            current = current.next(s.charAt(i));
        }
        return current.terminating;
    }

    /**
     * @param s Input String
     */
    public void insert(final String s) {
        TrieNode current = root;

        for (int i = 0; i < s.length(); i++) {
            if (current.trieNodes[s.charAt(i) - 'a'] == null)
                current.trieNodes[s.charAt(i) - 'a'] = new TrieNode();

            current = current.next(s.charAt(i));
        }
        current.terminating++;
    }

    /**
     * method that deletes the String from trie Data Structure
     * @param s Input String
     */
    public void delete(final String s) {
        TrieNode current = root;

        for (int i = 0; i < s.length(); i++) {
            if (current == null)
                return;

            current = current.next(s.charAt(i));
        }
        if (current.terminating > 0)
            current.terminating--;
        else
            throw new RuntimeException("String doesn't Exist");
    }

    /**
     * Method to perform update operation
     * @param oldString old String that we want to replace
     * @param newString new String
     */
    public void update(final String oldString, final String newString) {
        delete(oldString);
        insert(newString);
    }
}
