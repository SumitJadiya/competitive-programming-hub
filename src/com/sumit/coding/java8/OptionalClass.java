package com.sumit.coding.java8;

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {

        /*
            String[] words = new String[10];
            String word = words[5].toLowerCase();
            System.out.print(word);

            The above code will throw:

            Exception in thread "main" java.lang.NullPointerException
            at com.sumit.coding.java8.OptionalClass.main(OptionalClass.java:6)

            To avoid abnormal termination, we use the Optional class.
            Optional is a container object which may or may not contain a non-null value.
        */

        String[] words = new String[10];
        Optional<String> checkNull = Optional.ofNullable(words[5]);
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.print(word);
        } else
            System.out.println("word is null");

        System.out.println();

        /*********** Example 1 ***********/
        // creating a string array
        String[] str = new String[5];

        // Setting value for 2nd index
        str[2] = "Geeks Classes are coming soon";

        // It returns an empty instance of Optional class
        Optional<String> empty = Optional.empty();
        System.out.println("Value of empty instance - " + empty);

        // It returns a non-empty Optional
        Optional<String> value = Optional.of(str[2]);
        System.out.println("Value - " + value);

        System.out.println();

        /*********** Example 2 ***********/
        // creating a string array
        str = new String[5];

        // Setting value for 2nd index
        str[2] = "Geeks Classes are coming soon";

        // It returns a non-empty Optional
        value = Optional.of(str[2]);

        // It returns value of an Optional.
        // If value is not present, it throws
        // an NoSuchElementException
        System.out.println("Value of Optional - " + value.get());

        // It returns hashCode of the value
        System.out.println("Value of HashCode - " + value.hashCode());

        // It returns true if value is present,
        // otherwise false
        System.out.println("Value Present or not - " + value.isPresent());
    }
}
