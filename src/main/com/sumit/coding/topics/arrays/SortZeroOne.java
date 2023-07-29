package main.com.sumit.coding.topics.arrays;

import java.util.Arrays;

import static org.apache.commons.lang3.ArrayUtils.swap;

/*
 * Problem URL : https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 * */
public class SortZeroOne {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        System.out.println(Arrays.toString(sortZeroOne(arr)));
    }

    private static int[] sortZeroOne(int[] arr) {

        int front = 0;
        int back = arr.length - 1;

        while (front < back) {
            if (arr[front] == 0) front++;
            else if (arr[back] == 1) back--;
            else {
                swap(arr, front, back);
                front++;
                back--;
            }
        }

        return arr;
    }
}
