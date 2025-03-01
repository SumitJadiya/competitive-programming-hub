package com.sumit.coding.patterns.slidingWindow;

import java.util.LinkedList;
import java.util.Queue;

// First negative integer in every window of size k
public class FirstNegativeInteger {

    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;

        System.out.println(printFirstNegativeInteger(arr, k));

        arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        k = 3;
        System.out.println(printFirstNegativeInteger(arr, k));
    }

    private static Queue<Integer> printFirstNegativeInteger(int[] arr, int k) {
        int len = arr.length;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < len - k + 1; i++) {
            int min = findMinInRange(arr, i, i + k);
            queue.add(min);
        }

        return queue;
    }

    private static int findMinInRange(int[] arr, int start, int end) {
        int min = 0;

        for (int i = start; i < end; i++)
            if (arr[i] < min)
                return arr[i];

        return min;
    }
}
