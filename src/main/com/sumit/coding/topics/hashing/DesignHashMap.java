package main.com.sumit.coding.topics.hashing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DesignHashMap {
    int keySpace;
    Bucket[] buckets;

    public DesignHashMap() {
        keySpace = 2069;
        buckets = new Bucket[2069];
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new Bucket();
    }

    public void put(int key, int value) {
        int hashKey = calculateHash(key);
        buckets[hashKey].update(key, value);
    }

    public int get(int key) {
        int hashKey = calculateHash(key);
        return buckets[hashKey].get(key);
    }

    public void remove(int key) {
        int hashKey = calculateHash(key);
        buckets[hashKey].remove(key);
    }

    private static int calculateHash(int number) {
        int hashBase = 2069;
        return number % hashBase;
    }

    public static void main(String[] args) {
        DesignHashMap inputHashMap = new DesignHashMap();
        List<Integer> keys = Arrays.asList(5, 2069, 2070, 2073, 4138, 2068);
        List<Integer> keysList = new ArrayList<>(Arrays.asList(5, 2069, 2070, 2073, 4138, 2068));
        List<Integer> values = Arrays.asList(100, 200, 400, 500, 1000, 5000);
        List<String> funcs = Arrays.asList("Get", "Get", "Put", "Get", "Put", "Get", "Get", "Remove", "Get", "Get", "Remove", "Get");
        List<List<Integer>> funcKeys = Arrays.asList(
                List.of(5),
                List.of(2073),
                Arrays.asList(2073, 50),
                List.of(2073),
                Arrays.asList(121, 110),
                List.of(121),
                List.of(2068),
                List.of(2069),
                List.of(2069),
                List.of(2071),
                List.of(2071),
                List.of(2071)
        );

        for (int i = 0; i < keys.size(); i++)
            inputHashMap.put(keys.get(i), values.get(i));

        for (int i = 0; i < funcs.size(); i++) {
            if (Objects.equals(funcs.get(i), "Put")) {
                System.out.println(i + 1 + ".\t put(" + funcKeys.get(i).get(0) + ", " + funcKeys.get(i).get(1) + ")");
                if (!(keysList.contains(funcKeys.get(i).get(0))))
                    keysList.add(funcKeys.get(i).get(0));

                inputHashMap.put(funcKeys.get(i).get(0), funcKeys.get(i).get(1));
            } else if (Objects.equals(funcs.get(i), "Get")) {
                System.out.println(i + 1 + ".\t get(" + funcKeys.get(i).get(0) + ")");
                System.out.println("\t Value returned: " + inputHashMap.get(funcKeys.get(i).get(0)));
            } else if (Objects.equals(funcs.get(i), "Remove")) {
                System.out.println(i + 1 + ". \t remove(" + funcKeys.get(i).get(0) + ")");
                inputHashMap.remove(funcKeys.get(i).get(0));
            }

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

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