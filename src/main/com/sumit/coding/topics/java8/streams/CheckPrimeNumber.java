package com.sumit.coding.topics.java8.streams;

import java.util.List;

public class CheckPrimeNumber {

    // Check if a list of integers contains a prime number using Java streams.
    public static void main(String[] args) {
        List<Integer> numbers = List.of(16, 76, 7, 53, 51, 82, 6, 6, 79, 89, 97, 78, 56, 99, 26);

        boolean isPrime = numbers
                .stream()
                .anyMatch(PrimeUtils::checkPrime);


        System.out.println("Check if a list of integers contains a prime number using Java streams : " + isPrime);
    }

    static class PrimeUtils {

        public static boolean checkPrime(int number) {

            if (number < 2) {
                return false;
            }

            boolean isPrime = true;
            int sqrt = (int) Math.sqrt(number);

            for (int idx = 2; idx <= sqrt; idx++) {
                if (number % idx == 0) {
                    isPrime = false;
                    break;
                }
            }

            return isPrime;
        }
    }
}
