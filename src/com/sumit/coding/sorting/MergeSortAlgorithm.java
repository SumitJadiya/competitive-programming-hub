package com.sumit.coding.sorting;

/**
 * Problem URL:
 * https://www.interviewbit.com/tutorial/merge-sort-algorithm/
 */
public class MergeSortAlgorithm implements SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {14, 7, 3, 12, 9, 11, 6, 2};
        MergeSortAlgorithm mergeSortAlgorithm = new MergeSortAlgorithm();

        mergeSortAlgorithm.mergeSort(arr, 0, arr.length - 1);

        mergeSortAlgorithm.printArray(arr);
    }

    /**
     * Method breaking big array into smaller arrays for sorting
     *
     * @param arr   Input Array
     * @param start Starting Index
     * @param end   Last Index
     */
    private void mergeSort(int[] arr, int start, int end) {

        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    /**
     * Main function performing merging operation
     *
     * @param arr   Input Array
     * @param start Starting Index
     * @param mid   Mid Index
     * @param end   Last Index
     */
    private void merge(int[] arr, int start, int mid, int end) {

        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j])
                temp[k] = arr[i++];
            else
                temp[k] = arr[j++];
            k++;
        }

        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= end)
            temp[k++] = arr[j++];

        for (int l = start; l <= end; l++) {
            arr[l] = temp[l - start];
        }
    }
}
