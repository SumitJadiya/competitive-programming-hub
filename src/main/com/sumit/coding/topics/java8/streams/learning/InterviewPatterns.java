package com.sumit.coding.topics.java8.streams.learning;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterviewPatterns {

    /*
     * {"Pune","MuMBAI","PUnE","NagPUR", "MumBaI", "Nashik"}
     * pune: 2
     * mumbai : 2
     * nagpur : 1
     * */
    public static void main(String[] args) {
        List<String> strings = List.of("Pune", "MuMBAI", "PUnE", "NagPUR", "MumBaI", "Nashik");
        Map<String, Long> map = strings.stream().map(String::toLowerCase).collect(Collectors.groupingBy(str -> str, Collectors.counting()));

        System.out.println(map);
    }
}
