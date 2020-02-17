package main.com.sumit.coding.hashing;

import java.util.HashSet;

public class SingleNumber {

    public static void main(String[] args) {

        int[] arr = {4, 1, 2, 1, 2};
        System.out.print(new SingleNumber().returnSingleNumber(arr));
    }

    private int returnSingleNumber(int[] arr) {

        if (arr.length < 1)
            return Integer.MIN_VALUE;

        int result = 0;
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (hs.contains(arr[i]))
                hs.remove(arr[i]);
            else
                hs.add(arr[i]);
        }

        // if number is repeating the sum will be printed
        for (int x : hs)
            result += x;

        return result;
    }
}
