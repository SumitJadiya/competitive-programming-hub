package com.sumit.coding.topics.math;

import java.util.HashMap;
import java.util.Map;

public class SumOfAllDivisorsProblem {

    private static final Map<Integer, Integer> cache = new HashMap<>();
    
    public static int sumOfAllDivisors(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (cache.containsKey(i))
                sum += cache.get(i);
            else {
                int divisorSum = sumOfDivisors(i);
                cache.put(i, divisorSum);
                sum += divisorSum;
            }
        }

        return sum;
    }

    public static int sumOfDivisors(int n) {
        if (cache.containsKey(n))
            return cache.get(n);

        int sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;

                if (i != n / i)
                    sum += n / i;
            }
        }

        cache.put(n, sum);

        return sum;
    }

    public static void main(String[] args) {
        int n = 10_000;

        long startTime = System.nanoTime();
        int result = sumOfAllDivisors(n);
        long endTime = System.nanoTime();

        System.out.println("Result: " + result);
        System.out.println("Execution Time (ms): " + (endTime - startTime) / 1_000_000.0);
    }
}
