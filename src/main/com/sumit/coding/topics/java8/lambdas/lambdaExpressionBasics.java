package com.sumit.coding.topics.java8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lambdaExpressionBasics {

    record Person(String firstName, String lastName) {

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {
//        lambda_comparator_example();
        lambda_consumer_example();
    }

    public static void lambda_comparator_example() {
        List<Person> people = new ArrayList<>(Arrays.asList(new Person("Aucty", "Aneby"), new Person("Lucty", "Neby"), new Person("Sally", "Brown"), new Person("Linus", "Petty"), new Person("Charlie", "Brown")));
        var comparatorLastName = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        };
        people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));
        System.out.println(people);

        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }

        var comparatorMixed = new EnhancedComparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName().compareTo(o2.firstName());
            }
        };
        people.sort(comparatorMixed);
        System.out.println(people);

    }

    public static void lambda_consumer_example() {
        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        for (String s : list) System.out.println(s);

        System.out.println("------------------");
        list.forEach(System.out::println);

        System.out.println("------------------");
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(myString + " : " + first);
        });
    }
}
