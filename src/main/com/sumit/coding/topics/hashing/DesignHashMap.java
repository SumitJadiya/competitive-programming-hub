package main.com.sumit.coding.topics.hashing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class DesignHashMap {

    public DesignHashMap() {
        // Write your code here
    }

    private static int calculateHash(int number) {
        int hashBase = 2069;
        return number % hashBase;
    }

    public void put(int key, int value) {
        // Write your code here
    }

    public int get(int key) {
        // Replace this placeholder return statement with your code
        return -1;
    }

    public void remove(int key) {
        // Write your code here
    }

    public static void main(String[] args) {
        System.out.println(calculateHash(2069));
        Bucket[] buckets = new Bucket[2069];
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new Bucket();

        // Example usage:
        int[][] keyValuePair = {{1, 1000}, {2070, 2000}, {2068, 3000}};
        int i = 1;
        for (int[] pair : keyValuePair) {
            int key = pair[0];
            int value = pair[1];
            int hashKey = calculateHash(key);
            System.out.println(i + ".\tInserting key-value pair: Key = " + key + ", Value = " + value + ", HashKey = " + hashKey);
            buckets[hashKey].update(key, value);

            // Retrieving values
            System.out.println("\tRetrieving value for key " + key + ": " + buckets[hashKey].get(key) + "\n");
            i++;
        }

        // Removing a key
        int keyToRemove = keyValuePair[keyValuePair.length - 1][0];
        System.out.println(i + ".\tRemoving key " + keyToRemove);
        buckets[calculateHash(keyToRemove)].remove(keyToRemove);
        System.out.println("\tValue for key " + keyToRemove + " after removal: " + buckets[calculateHash(keyToRemove)].get(keyToRemove));  // Output: -1 (removed)
    }

}

class Bucket {

    List<Pair<Integer, Integer>> bucket;

    public Bucket() {
        bucket = new ArrayList<>();
    }

    // put value in bucket
    public void update(int key, int value) {
        boolean found = false;

        for (int i = 0; i < bucket.size(); i++) {
            Pair<Integer, Integer> pair = bucket.get(i);
            if (key == pair.getKey()) {
                bucket.set(i, new Pair<>(key, value));
                found = true;
                break;
            }
        }

        if (!found)
            bucket.add(new Pair<>(key, value));
    }

    // get value from bucket
    public int get(int key) {
        for (Pair<Integer, Integer> pair : bucket) {
            if (key == pair.getKey()) return pair.getValue();
        }
        return -1;
    }

    // delete value from bucket
    public void remove(int key) {
        for (int i = 0; i < bucket.size(); i++) {
            Pair<Integer, Integer> pair = bucket.get(i);
            if (key == pair.getKey()) {
                bucket.remove(i);
                break;
            }
        }
    }
}

@Getter
@Setter
@AllArgsConstructor
class Pair<K, V> {
    private K key;
    private V value;


}