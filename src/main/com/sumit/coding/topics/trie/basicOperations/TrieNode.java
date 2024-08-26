package com.sumit.coding.topics.trie.basicOperations;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class TrieNode {
    Map<Character, TrieNode> child;
    boolean isEndOfWord;

    protected TrieNode() {
        child = new HashMap<>();
        isEndOfWord = false;
    }
}
