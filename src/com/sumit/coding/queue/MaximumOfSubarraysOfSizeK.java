package com.sumit.coding.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumOfSubarraysOfSizeK {

    public static void main(String[] args) {

        int k = 4;
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
//        int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        MaximumOfSubarraysOfSizeK maximumOfSubarraysOfSizeK = new MaximumOfSubarraysOfSizeK();

        maximumOfSubarraysOfSizeK.printQueue(maximumOfSubarraysOfSizeK.maximumOfSubarrays(arr, k));
    }

    private Queue<Integer> maximumOfSubarrays(int[] arr, int k) {

        int i;
        int max;

        Queue<Integer> queue = new LinkedList<>();

        for (int j = 0; j <= arr.length - k; j++) {
            max = arr[j];
            for (i = 1; i < k; i++) {
                if (arr[i + j] > max) {
                    max = arr[i + j];
                }
            }
            queue.add(max);
        }

        return queue;
    }

    private void printQueue(Queue<Integer> queue) throws NullPointerException {

        if (queue.size() == 0)
            throw new NullPointerException("Empty Queue");

        while (queue.size() > 0) {
            System.out.print(queue.peek() + " ");
            queue.remove();
        }
    }
}
