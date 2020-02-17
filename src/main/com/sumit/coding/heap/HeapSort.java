package main.com.sumit.coding.heap;

public class HeapSort {
    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted Array Is - ");
        printArray(arr);
    }

    public static void heapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // if left child is larger than the root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // if right child is larger than the root
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // if largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void printArray(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public void sort(int[] arr) {
        int n = arr.length;

        // build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by One Extract element from Heap
        for (int i = n - 1; i >= 0; i--) {

            // move current to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify for reduced heap
            heapify(arr, i, 0);
        }
    }
}
