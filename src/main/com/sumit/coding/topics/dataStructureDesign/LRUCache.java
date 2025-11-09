package com.sumit.coding.topics.dataStructureDesign;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private static class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
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
    }

    int capacity;
    Map<Integer, Node> cache = new HashMap<>();
    DLL list = new DLL();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }

    private int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        list.removeNode(node);
        list.addToFront(node);

        return node.value;
    }

    private void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            list.removeNode(node);
            list.addToFront(node);

            return;
        }

        if (cache.size() >= capacity) {
            Node recentlyUsedNode = list.tail.prev;
            list.removeNode(recentlyUsedNode);
            cache.remove(recentlyUsedNode.key);
        }

        Node node = new Node(key, value);
        list.addToFront(node);

        cache.put(key, node);
    }
}


/*
 * - key is already present -> remove, add to front : DONE
 * - key is not present ->
 *   - capacity?
 *       - yes-> simply add
 *       - no -> remove the latest node
 * */
