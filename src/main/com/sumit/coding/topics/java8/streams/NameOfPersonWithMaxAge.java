package com.sumit.coding.topics.java8.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NameOfPersonWithMaxAge {

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person("Virat", 35),
                new Person("Tendulkar", 44),
                new Person("Rishabh", 25),
                new Person("Bumrah", 32),
                new Person("Riyan", 19),
                new Person("Riyan", 19)
        );

        //    Get the name of a person with max-age.
        Person person = persons
                .stream()
                .max(Comparator.comparingInt(Person::getAge))
                .get();


        System.out.println("Name with max age :  " + person.getName() + " - " + person.getAge());

        //    Get the name of a person with min-age.
        person = persons
                .stream()
                .min(Comparator.comparingInt(Person::getAge))
                .get();

        System.out.println("Name with min age :  " + person.getName() + " - " + person.getAge());

        // Get the age of a duplicate person.
        Map<String, Set<Person>> duplicates = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.toSet()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        duplicates.forEach((name, personList) -> {
            System.out.println("duplicates");
            personList.forEach(thisPerson -> {
                System.out.print(name + " : ");
                System.out.println(thisPerson.getAge());
            });
        });


    }

    @AllArgsConstructor
    @Getter
    static class Person {
        private String name;
        private int age;
    }
}
