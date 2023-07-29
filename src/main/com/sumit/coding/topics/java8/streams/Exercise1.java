package main.com.sumit.coding.topics.java8.streams;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        System.out.println("Print all numbers in the intNumbersStream stream");
        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream()
                .forEach(System.out::println);

        System.out.println("Print numbers from intNumbersStream that are less than 5");
        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream()
                .filter(num -> num > 5)
                .forEach(System.out::println);

        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
                .filter(num -> num > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("Print the first number in intNumbersStream that's greater than 5.");
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer firstNumberGreaterThan5 = StreamSources.intNumbersStream()
                .filter(num -> num > 50)
                .findFirst()
                .orElse(-1);
        System.out.println(firstNumberGreaterThan5);

        System.out.println("Print first names of all users in userStream");
        // Print first names of all users in userStream
        StreamSources.userStream()
                .map(user -> (user.getFirstName()))
                .forEach(System.out::println);

        System.out.println("Print first names in userStream for users that have IDs from number stream");
        // Print first names in userStream for users that have IDs from number stream
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(User::getFirstName)
                .forEach(System.out::println);

        // another way
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(i -> i == user.getId()))
                .map(User::getFirstName)
                .forEach(System.out::println);

    }
}
