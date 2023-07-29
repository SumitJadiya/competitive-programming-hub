package main.com.sumit.coding.topics.trie.basicOperations;

import java.util.ArrayList;
import java.util.List;

/**
 *  Class to perform basic operations in Trie
 */
public class TrieBasicOperations {
    public static void main(String[] args) {
        final List<String> setOfStrings = new ArrayList<>();
        setOfStrings.add("pqrs");
        setOfStrings.add("pprt");
        setOfStrings.add("psst");
        setOfStrings.add("qqrs");
        setOfStrings.add("pqrs");

        Trie trie = new Trie();
        setOfStrings.forEach(trie::insert);

        // Basic CRUD operations can be performed here!
    }
}
