package com.sumit.coding.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,2,3);
        List<String> stringList = Arrays.asList("C", "CPP", "Java", "JS", "Go", "Python", "Cobol");

        for (int i=0; i<10; i++)
            list.add(i);

        Stream<Integer> allNumbers = list.stream();
        Stream<Integer> evenNumbers = list.stream();
        Stream<Integer> distinctNumbers = intList.stream();
        Stream<String> stringStream = stringList.stream();

        // print all numbers
        allNumbers.forEach(p -> System.out.print(p + " "));
        System.out.println();

        // print even numbers
        evenNumbers.filter(n -> (n%2)==0 ).forEach(p-> System.out.print(p + " "));
        System.out.println();

        // print distinct numbers
        distinctNumbers.distinct().forEach(System.out::print);
        System.out.println();

        // Convert Stream into list
        List<String> stringGreaterThanTwo = stringStream
                .filter(s -> s.length()>2)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(stringGreaterThanTwo);

    }

}
