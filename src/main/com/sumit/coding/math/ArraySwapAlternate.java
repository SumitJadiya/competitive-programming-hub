package main.com.sumit.coding.math;

import java.util.Arrays;

public class ArraySwapAlternate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int size = arr.length;

        for (int i = 0; i < size; i = i + 2)
            if (i + 1 < size) new ArraySwapAlternate().swap(arr, i, i + 1);

        System.out.println(Arrays.toString(arr));
    }

    private void swap(int[] arr, int first, int second) {
        arr[first] = arr[first] + arr[second];
        arr[second] = arr[first] - arr[second];
        arr[first] = arr[first] - arr[second];
    }
}
