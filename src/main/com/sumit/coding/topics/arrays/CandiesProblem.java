package main.com.sumit.coding.topics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem Statement -> https://www.hackerrank.com/challenges/candies/problem
 * */
public class CandiesProblem {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 2, 6, 1, 7, 8, 9, 2, 1));
        System.out.println(candies(list.size(), list));
    }

    /*
    * Returns number of candies
    * */
    public static long candies(int n, List<Integer> arr) {
        long[] candies = new long[n];

        for (int i = 0; i < n; i++)
            candies[i] = (i > 0 && arr.get(i - 1) < arr.get(i)) ? candies[i - 1] + 1 : 1;
        for (int i = n - 1; i > 0; i--)
            candies[i - 1] = (arr.get(i) < arr.get(i - 1)) ? Math.max(candies[i - 1], candies[i] + 1) : candies[i - 1];

        return Arrays.stream(candies).sum();
    }
}
