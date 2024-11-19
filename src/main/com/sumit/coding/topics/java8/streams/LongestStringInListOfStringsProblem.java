package com.sumit.coding.topics.java8.streams;

import java.util.Comparator;
import java.util.List;

public class LongestStringInListOfStringsProblem {
    //1. Find the longest string in a list of strings using Java streams
    public static void main(String[] args) {
        List<String> strings = List.of("Sumit", "Jadiya", "Sachin", "Tendulkar", "Rachin", "Ravindra", "Virat", "Kohli");

        String longestString = strings.stream().max(Comparator.comparingInt(String::length)).get();

        System.out.println("Longest String : " + longestString);
    }
}
