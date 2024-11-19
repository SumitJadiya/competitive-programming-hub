package com.sumit.coding.topics.java8.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class AverageAgeOfPersons {

//    Calculate the average age of a list of Person objects using Java streams.

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Virat", 35),
                new Person("Tendulkar", 44),
                new Person("Rishabh", 25),
                new Person("Bumrah", 32)
        );

        double averageAge = persons
                .stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);

        System.out.println("average age :" + averageAge);
    }

    @AllArgsConstructor
    @Getter
    static class Person {
        private String name;
        private int age;
    }
}
