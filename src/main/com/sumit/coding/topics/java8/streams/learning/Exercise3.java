package com.sumit.coding.topics.java8.streams.learning;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        Flux<Integer> list = ReactiveSources.intNumbersFlux();
        list.subscribe(System.out::println);

        list.count().subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }
}
