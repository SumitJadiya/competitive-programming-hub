package com.sumit.coding.topics.java8plus.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.*;

public class Basics {

    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});
        Iterator<Integer> iterator = numbers.iterator();
        numbers.add(10);

        System.out.println(numbers);
        List<Integer> result = new LinkedList<>();
        iterator.forEachRemaining(result::add);
        System.out.println(result);



    }
}
