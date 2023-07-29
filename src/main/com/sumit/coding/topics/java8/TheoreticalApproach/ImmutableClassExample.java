package main.com.sumit.coding.topics.java8.TheoreticalApproach;

import java.util.HashMap;

/*
 * An object is immutable when its state doesn’t change after it has been initialized.
 * For example, String is an immutable class and, once instantiated, the value of a String object never changes.
 *
 * Because an immutable object can’t be updated, programs need to create a new object for every change of state.
 * However, immutable objects also have the following benefits:
 *   An immutable class is good for caching purposes because you don’t have to worry about the value changes.
 *   An immutable class is inherently thread-safe, so you don’t have to worry about thread safety in multi-threaded environments.
 *
 * Creating an Immutable Class in Java
 * To create an immutable class in Java, you need to follow these general principles:
 *
 *   Declare the class as final, so it can’t be extended.
 *   Make all the fields private so that direct access is not allowed.
 *   Don’t provide setter methods for variables.
 *   Make all mutable fields final so that a field’s value can be assigned only once.
 *   Initialize all fields using a constructor method performing deep copy.
 *   Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
 * */
public class ImmutableClassExample {

    // fields of the FinalClassExample class
    private final int id;

    private final String name;

    private final HashMap<String, String> testMap;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Getter function for mutable objects
    public HashMap<String, String> getTestMap() {
        return (HashMap<String, String>) testMap.clone();
    }

    // Constructor method performing deep copy
    public ImmutableClassExample(int i, String n, HashMap<String, String> hm) {
        System.out.println("Performing Deep Copy for Object initialization");

        // "this" keyword refers to the current object
        this.id = i;
        this.name = n;

        HashMap<String, String> tempMap = new HashMap<>();
        String key;
        for (String s : hm.keySet()) {
            key = s;
            tempMap.put(key, hm.get(key));
        }
        this.testMap = tempMap;
    }

    // Test the immutable class
    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<>();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i = 10;

        ImmutableClassExample ce = new ImmutableClassExample(i, s, h1);

        // print the ce values
        System.out.println("ce id: " + ce.getId());
        System.out.println("ce name: " + ce.getName());
        System.out.println("ce testMap: " + ce.getTestMap());

        // change the local variable values
        i = 20;
        s = "modified";
        h1.put("3", "third");

        // print the values again
        System.out.println("ce id after local variable change: " + ce.getId());
        System.out.println("ce name after local variable change: " + ce.getName());
        System.out.println("ce testMap after local variable change: " + ce.getTestMap());

        HashMap<String, String> hmTest = ce.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from getter methods: " + ce.getTestMap());
    }
}
