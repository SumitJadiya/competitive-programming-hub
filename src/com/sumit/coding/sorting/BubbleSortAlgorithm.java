package com.sumit.coding.sorting;

/**
 * Problem URL:
 * https://www.interviewbit.com/tutorial/bubble-sort/
 */
public class BubbleSortAlgorithm implements SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 7, 2, 1, 0, 3};

        BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
        bubbleSortAlgorithm.sort(arr);

        bubbleSortAlgorithm.printArray(arr);
    }

    /**
     * Method that performs sorting operation
     *
     * @param arr Input Array
     */
    private void sort(int[] arr) {

        boolean swapped;
        int n = arr.length;
        BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    bubbleSortAlgorithm.swap(arr, j, j + 1);
                    swapped = true;
                }

            }
            if (!swapped)
                break;
        }
    }
}
