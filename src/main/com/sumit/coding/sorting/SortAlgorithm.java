package main.com.sumit.coding.sorting;

/**
 * Interface for All type of sorting Algorithms
 */
public interface SortAlgorithm {
    /**
     * Print Array
     *
     * @param arr Input Array
     */
    default void printArray(int[] arr) {
        for (int val : arr)
            System.out.print(val + " ");
    }

    /**
     * Method to perform swapping operation
     *
     * @param arr      Input Array
     * @param i        Index
     * @param minIndex Index
     */
    default void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
