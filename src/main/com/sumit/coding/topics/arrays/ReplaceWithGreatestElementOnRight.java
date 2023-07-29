package main.com.sumit.coding.topics.arrays;

import java.util.Arrays;

public class ReplaceWithGreatestElementOnRight {

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        // int[] arr = {400};
        System.out.println(Arrays.toString(new ReplaceWithGreatestElementOnRight().replaceElements(arr)));
    }

    public int[] replaceElements(int[] arr) {
        int maxNumber = -1, n = arr.length, a;

        for (int i = n - 1; i >= 0; --i) {
            a = arr[i];
            arr[i] = maxNumber;
            maxNumber = Math.max(maxNumber, a);
        }

        return arr;
    }
}
