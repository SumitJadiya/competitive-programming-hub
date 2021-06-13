package main.com.sumit.coding.hashing;

import java.util.LinkedList;

class HashSetBucket {
    private LinkedList<Integer> container;

    public HashSetBucket() {
        container = new LinkedList<>();
    }

    public void insert(Integer key) {
        int index = this.container.indexOf(key);
        if (index == -1)
            this.container.addFirst(key);
    }

    public void delete(Integer key) {
        this.container.remove(key);
    }

    public boolean contains(Integer key) {
        return this.container.contains(key);
    }
}

public class ImplementHashSet {
    private HashSetBucket[] bucketArray;
    private int keyRange;

    /** Initialize your data structure here. */
    public ImplementHashSet() {
        keyRange = 887;
        bucketArray = new HashSetBucket[this.keyRange];

        for (int i=0; i<this.keyRange; i++)
            this.bucketArray[i] = new HashSetBucket();
    }

    public int _hashcode(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int index = this._hashcode(key);
        this.bucketArray[index].insert(key);
    }

    public void remove(int key) {
        int index = this._hashcode(key);
        this.bucketArray[index].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = this._hashcode(key);
        return this.bucketArray[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
