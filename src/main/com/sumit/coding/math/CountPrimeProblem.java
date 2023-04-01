package main.com.sumit.coding.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Count Primes
 * Problem URL : https://leetcode.com/problems/count-primes/
 * */
public class CountPrimeProblem {

    public static void main(String[] args) {
        int n = 10;

        CountPrimeProblem countPrimeProblem = new CountPrimeProblem();
        long startTime = System.nanoTime();
        System.out.println(segmentedSieve(n));
        System.out.println((System.nanoTime() - startTime)/ 1_000_000_000.0 + " Sec");

        startTime = System.nanoTime();
        System.out.println(countPrimeProblem.countPrimes(n));
        System.out.println((System.nanoTime() - startTime)/ 1_000_000_000.0 + " Sec");


    }

    /*
     * Time Complexity : O(n * log (log n))
     * */
    public int countPrimes(int n) {
        var primes = new boolean[n];
        int count = 0;

        if (n <= 1) return 0;
        Arrays.fill(primes, true);

        primes[0] = primes[1] = false;

        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;

                for (int j = 2 * i; j < n; j = j + i)
                    primes[j] = false;
            }
        }

        return count;
    }

    /*
     * Time Complexity : O(sqrt n)
     * */
    static void simpleSieve(int limit, List<Integer> prime) {
        boolean[] mark = new boolean[limit + 1];

        Arrays.fill(mark, true);

        for (int p = 2; p * p < limit; p++) {
            if (mark[p]) {
                for (int i = p * p; i < limit; i += p)
                    mark[i] = false;
            }
        }

        for (int p = 2; p < limit; p++) {
            if (mark[p])
                prime.add(p);
        }
    }

    static int segmentedSieve(int n) {
        int limit = (int) (Math.floor(Math.sqrt(n)) + 1);

        List<Integer> prime = new ArrayList<>();
        simpleSieve(limit, prime);

        int count = prime.size();

        int low = limit;
        int high = 2 * limit;

        while (low < n) {
            if (high >= n)
                high = n;

            boolean[] mark = new boolean[limit + 1];

            for (Integer integer : prime) {
                int loLimit = (int) (Math.floor(low / integer) * integer);
                if (loLimit < low)
                    loLimit += integer;

                for (int j = loLimit; j < high; j += integer)
                    mark[j - low] = true;
            }

            for (int i = low; i < high; i++)
                if (!mark[i - low])
                    count++;

            // Update low and high for next segment
            low = low + limit;
            high = high + limit;
        }

        return count;
    }
}
