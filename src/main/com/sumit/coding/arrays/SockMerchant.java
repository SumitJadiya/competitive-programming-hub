package main.com.sumit.coding.arrays;

import java.util.HashSet;

/*
 *
 *   Solution to the problem
 *   https://www.hackerrank.com/challenges/sock-merchant/problem
 *
 * */

public class SockMerchant {
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(arr.length, arr));
    }

    private static int sockMerchant(int n, int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        int count = 0;
        for (int val : arr) {
            if (set.contains(val)) {
                count++;
                set.remove(val);
            } else
                set.add(val);

        }
        return count;
    }
}
