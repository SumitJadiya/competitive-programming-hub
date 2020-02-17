package main.com.sumit.coding.heap;

public class BuildHeap {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        int n = arr.length;

        buildHeap(arr, n);
        printHeap(arr, n);
    }

    public static void buildHeap(int arr[], int n) {

        // Index of last non leaf node
        int startIndex = (n / 2) - 1;

        // Perform reverse level order traversal from last non-leaf node and heapify each node
        for (int i = startIndex; i >= 0; i--)
            heapify(arr, n, i);

    }

    public static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialise largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void printHeap(int[] arr, int n) {
        System.out.println("Array Representation of Heap is : ");

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
