package com.sumit.coding.topics.math;

public class CheckPrimeNumberProblem {

    public static void main(String[] args) {
        int n = 79;

        long startTime = System.nanoTime();
        boolean result = checkPrime(n);
        long endTime = System.nanoTime();

        System.out.println("Result: " + result);
        System.out.println("Execution Time (ms): " + (endTime - startTime) / 1_000_000.0);
    }

    private static boolean checkPrime(int n) {
        boolean result = true;

        for (int i = 2; i*i < n; i++) {

            if(n % i == 0) return false;
        }

        return result;
    }
}
