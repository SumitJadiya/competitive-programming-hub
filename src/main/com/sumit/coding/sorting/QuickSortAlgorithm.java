package main.com.sumit.coding.sorting;

/**
 * Problem URL:
 * https://www.interviewbit.com/tutorial/quicksort-algorithm/
 */
public class QuickSortAlgorithm implements SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {50, 23, 9, 18, 61, 32};
        QuickSortAlgorithm quickSortAlgorithm = new QuickSortAlgorithm();

        quickSortAlgorithm.sort(arr, 0, arr.length - 1);

        quickSortAlgorithm.printArray(arr);
    }

    /**
     * The main function that implements Quick Sort
     *
     * @param arr  Input Array
     * @param low  Starting Index
     * @param high Last Index
     */
    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    /**
     * Logic for partition in quick sort
     *
     * @param arr  Input Array
     * @param low  Starting Index
     * @param high Last Index
     * @return returns partition index
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
