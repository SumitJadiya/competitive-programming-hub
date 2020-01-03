package com.sumit.coding.arrays;

import java.util.Arrays;

public class SpecialPrimeProblem {

    public static void main(String[] args) {

        int[] arr = {31, 5, 2, 1, 7, 6};
        int a[] = new int[arr.length];
        int k = 0;
        int n = arr.length;

        SpecialPrimeProblem.checkSpecialPrime(arr, a, k, n);
        System.out.println();
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 ||
                n % 3 == 0)
            return false;

        for (int i = 5;
             i * i <= n; i = i + 6)
            if (n % i == 0 ||
                    n % (i + 2) == 0)
                return false;

        return true;
    }

    private static void checkSpecialPrime(int[] arr, int[] a, int k, int n) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 2 && isPrime(arr[i]) && (isPrime(arr[i] - 2)))
                a[k++] = arr[i];
        }

        int ans[] = new int[arr.length];
        Arrays.sort(a);

        int j = n - k;
        for (int i = 0; i < n; i++) {

            if (arr[i] > 2 && isPrime(arr[i]) && (isPrime(arr[i] - 2))) {
                ans[i] = a[j++];
            } else {
                ans[i] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
