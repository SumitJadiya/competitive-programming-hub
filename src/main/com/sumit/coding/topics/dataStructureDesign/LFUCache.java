package com.sumit.coding.topics.dataStructureDesign;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private static class Node {
        int key, value;
        int freq;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private static class DLL {
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);

        public DLL() {
            head.next = tail;
            tail.prev = head;
        }

        /* Utility Methods */

        private void addToFront(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public Node removeLast() {
            Node node = tail.prev;
            removeNode(node);
            return node;
        }
    }

    int capacity;
    int minFreq = 0;

    Map<Integer, Node> cache = new HashMap<>();
    Map<Integer, DLL> freqList = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    private int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        updateFreq(node);

        return node.value;
    }

    private void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFreq(node);

            return;
        }

        if (cache.size() >= capacity) {
            Node deadNode = freqList.get(minFreq).removeLast();
            cache.remove(deadNode.key);
        }

        Node node = new Node(key, value);
        freqList.computeIfAbsent(1, f -> new DLL()).addToFront(node);
        cache.put(key, node);
        minFreq = 1;
    }

    private void updateFreq(Node node) {
        DLL oldList = freqList.get(node.freq);
        oldList.removeNode(node);

        if (node.freq == minFreq && oldList.head.next == oldList.tail)
            minFreq++;

        node.freq++;

        freqList.computeIfAbsent(1, f -> new DLL()).addToFront(node);
    }

    public static void main(String[] args) {
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(1, 1);
        lFUCache.put(2, 2);
        System.out.println(lFUCache.get(1));
        lFUCache.put(3, 3);
        System.out.println(lFUCache.get(2));
        lFUCache.put(4, 4);
        System.out.println(lFUCache.get(1));
        System.out.println(lFUCache.get(3));
        System.out.println(lFUCache.get(4));
    }
}

