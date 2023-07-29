package main.com.sumit.coding.topics.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsAPIProblems {

    private List<String> memberNames = new ArrayList<>();

    private StreamsAPIProblems() {

        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");
    }

    public static void main(String[] args) {

/*
        StreamsAPIProblems streamsAPIProblems = new StreamsAPIProblems();

        System.out.println("-------------Circuit Operations------------");
        System.out.println();
        streamsAPIProblems.circuitOperations();
        System.out.println("-------------Terminal Operations-----------");
        System.out.println();
        streamsAPIProblems.terminalOperations();
        System.out.println("-------------Distinct Operations-----------");
        System.out.println();
        streamsAPIProblems.distinctOperations();
        System.out.println("-------------Filter Operations-------------");
        System.out.println();
        streamsAPIProblems.filterOperation();
        System.out.println("-------------Find Operations---------------");
        System.out.println();
        streamsAPIProblems.findOperations();
        System.out.println("-------------Map Operations----------------");
        System.out.println();
        streamsAPIProblems.mapOperations();
        System.out.println("-------------Limit Operations--------------");
        System.out.println();
        streamsAPIProblems.limitSortCircuitOperation();

*/

        System.out.println(Locale.forLanguageTag("de-CH"));
    }

    private void circuitOperations() {
        // AllMatchSortCircuitTerminalOperation
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        boolean match = stream.allMatch(s -> s.contains("\\d+"));
        System.out.print("All Match = " + match + " ,");

        // AnyMatchSortCircuitOperation
        stream = Stream.of("one", "two", "three", "four");
        match = stream.anyMatch(s -> s.contains("four"));
        System.out.print("Any Match = " + match + " ,");

        // None Match
        stream = Stream.of("one", "two", "three", "four");
        match = stream.noneMatch(s -> s.contains("\\d+"));
        System.out.print("None Match = " + match);

        System.out.println();
    }

    private void terminalOperations() {

        // Count Terminal Operation
        long count = Stream.of("how", "to", "do", "in", "java").count();
        System.out.printf("There are %d elements in the stream %n", count);

        count = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).count();
        System.out.printf("There are %d elements in the stream %n", count);

        count = LongStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(i -> i % 2 == 0).count();
        System.out.printf("There are %d elements in the stream %n", count);

        // Max Terminal Operation
        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
        Optional<Integer> maxNumber = list.stream().max(Comparator.naturalOrder());
        System.out.print("Max = " + maxNumber.orElse(-1) + " ");

        // Min Terminal Operation
        list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
        Optional<Integer> minNumber = list.stream().min(Comparator.naturalOrder());
        System.out.println("Min = " + minNumber.orElse(-1) + " ");

        // Collect Terminal Operation
        List<String> listOfString = Arrays.asList("Java", "C", "C++", "Go", "JavaScript", "Python", "Scala");
        System.out.println("input list of String: " + listOfString);

        // Example 1 - converting Stream to List using collect() method
        List<String> listOfStringStartsWithJ = listOfString.stream().filter(s -> s.startsWith("J")).collect(Collectors.toList());
        System.out.println("list of String starts with letter J: " + listOfStringStartsWithJ);

        // Example 2 - converting Stream to Set
        Set<String> setOfStringStartsWithC = listOfString.stream().filter(s -> s.startsWith("C")).collect(Collectors.toSet());
        System.out.println("set of String starts with letter C: " + setOfStringStartsWithC);

        // Example 3 - converting Stream to Map
        Map<String, Integer> stringToLength = listOfString.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("map of string and their length: " + stringToLength);

        // Example 4- Converting Stream to Collection e.g. ArrayList
        ArrayList<String> stringWithLengthGreaterThanTwo = listOfString.stream().filter(s -> s.length() > 2).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("collection of String with length greather than 2: " + stringWithLengthGreaterThanTwo);
    }

    private void distinctOperations() {
        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);

        //   ForEach Terminal Operation
        //   intList.forEach(System.out::println);
        System.out.println("Numbers = " + intList);
        List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct Numbers = " + distinctIntList);
    }

    private void filterOperation() {
        System.out.print("Strings start with A = ");
        memberNames.stream().filter((s) -> s.startsWith("A")).forEach(System.out::println);
        System.out.print("Strings Equals Yana = ");
        memberNames.stream().filter((s) -> s.equals("Yana")).forEach(System.out::println);
    }

    private void findOperations() {
        // FindAny
        //sequential stream
        Stream.of("one", "two", "three", "four").findAny().ifPresent(System.out::println);
        //parallel stream
        Stream.of("one", "two", "three", "four").parallel().findAny().ifPresent(System.out::println);

        // FindFirst
        //sequential stream
        Stream.of("one", "two", "three", "four").findFirst().ifPresent(System.out::println);
        //parallel stream
        Stream.of("one", "two", "three", "four").parallel().findFirst().ifPresent(System.out::println);

    }

    private void mapOperations() {

        // Map operations
        memberNames.stream().filter((s) -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);
        memberNames.stream().filter((s) -> s.startsWith("A")).map(String::toLowerCase).forEach(System.out::println);

        List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> listOfIntegers = listOfStrings.stream().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println("list of Integers = " + listOfIntegers);

        // Sort
        System.out.println("Sorted = ");
        memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);

        // Flat Map Operations
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        System.out.println("listOfLists = " + listOfLists);

        List<Integer> listOfAllIntegers = listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("listOfAllIntegers = " + listOfAllIntegers);
    }

    private void limitSortCircuitOperation() {
        Stream<Integer> evenNumInfiniteStream = Stream.iterate(0, n -> n + 2);
        List<Integer> newList = evenNumInfiniteStream.limit(10).collect(Collectors.toList());
        System.out.println("Limit Operation = " + newList);
    }
}
