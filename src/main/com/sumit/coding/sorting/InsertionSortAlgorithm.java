package main.com.sumit.coding.sorting;


/**
 * Problem URL:
 * https://www.interviewbit.com/tutorial/insertion-sort-algorithm/
 */
public class InsertionSortAlgorithm implements SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        InsertionSortAlgorithm ob = new InsertionSortAlgorithm();
        ob.sort(arr);
        ob.printArray(arr);
    }

    /**
     * Time Complexity : O(n2)
     */
    private void sort(int[] arr) {
        int i = 1, j, key;
        int len = arr.length;

        while (i < len) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // shifting elements to right
                j--;
            }
            arr[j + 1] = key;
            i++;
        }
    }
}
