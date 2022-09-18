package main.com.sumit.coding.sorting;

/**
 * Selection Sort
 * Problem URL: https://www.interviewbit.com/tutorial/selection-sort
 */
public class SelectionSortAlgorithm implements SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {0, 5, 2, 6, 7, 2, 1, 0, 3};

        SelectionSortAlgorithm selectionSortAlgorithm = new SelectionSortAlgorithm();
        selectionSortAlgorithm.sort(arr);
        selectionSortAlgorithm.printArray(arr);
    }

    /**
     * Time Complexity : O(n2)
     * Space Complexity : O(1)
     * usecase - small size array
     */
    private void sort(int[] arr) {
        int minIndex;
        SelectionSortAlgorithm selectionSortAlgorithm = new SelectionSortAlgorithm();

        for (int i = 0; i < arr.length; i++) {
            minIndex = findMinIndex(arr, i);

            if (i != minIndex)
                selectionSortAlgorithm.swap(arr, i, minIndex);
        }
    }

    /**
     * Method to find minimum index
     *
     * @param arr   Input Array
     * @param start Starting Index
     */
    private int findMinIndex(int[] arr, int start) {
        int min = start;
        for (int j = start + 1; j < arr.length; j++) {
            if (arr[j] < arr[min])
                min = j;
        }
        return min;
    }
}
