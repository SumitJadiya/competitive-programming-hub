package com.sumit.coding.topics.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoSortedListIntoSingle {



    public static void main(String[] args) {

        List<Integer> firstList = Arrays.asList(17, 24, 27, 34, 39, 45, 50, 64, 65, 67, 69, 72, 74, 90, 94);
        List<Integer> secondList = Arrays.asList(3, 8, 10, 11, 20, 26, 35, 36, 39, 47, 50, 68, 70, 76, 90);

        // Merge two sorted lists into a single sorted list using Java streams
        List<Integer> mergedList = Stream
                .concat(firstList.stream(), secondList.stream())
                .sorted()
                .toList();

        System.out.println(mergedList);


        // the intersection of two lists using Java streams.
        List<Integer> intersectionList = firstList
                .stream()
                .filter(secondList::contains)
                .toList();

        System.out.println(intersectionList);
    }




}
