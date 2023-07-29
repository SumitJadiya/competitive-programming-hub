package main.com.sumit.coding.topics.queue;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfSubarraysOfSizeK {

    public static void main(String[] args) {

        int k = 3;
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
//        int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        MaximumOfSubarraysOfSizeK maximumOfSubarraysOfSizeK = new MaximumOfSubarraysOfSizeK();

        maximumOfSubarraysOfSizeK.maximumOfSubarray(arr, k);
    }

    private void maximumOfSubarray(int[] arr, int k) {

        Deque<Integer> queue = new LinkedList<>();

        /* Process first k (or first window) elements of array */
        int i;
        int n = arr.length;
        for (i = 0; i < k; ++i) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()])
                queue.removeLast(); // Remove from rear

            // Add new element at rear of queue
            queue.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[queue.peek()] + " ");

            // Remove the elements which are out of this window
            while ((!queue.isEmpty()) && queue.peek() <= i - k)
                queue.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!queue.isEmpty()) && arr[i] >= arr[queue.peekLast()])
                queue.removeLast();

            // Add current element at the rear of Qi
            queue.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[queue.peek()]);
    }
}
