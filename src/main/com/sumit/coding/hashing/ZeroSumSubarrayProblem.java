package main.com.sumit.coding.hashing;

import java.util.HashMap;

/**
 * Problem URL : https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
 */
public class ZeroSumSubarrayProblem {
    public static void main(String[] args) {

        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        System.out.println(new ZeroSumSubarrayProblem().checkZeroSum(arr));
    }

    public int checkZeroSum(int[] arr) {

        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0)
                count++;

            if (hmap.containsKey(sum)) {
                count += hmap.get(sum);
                hmap.put(sum, hmap.get(sum) + 1);
            } else
                hmap.put(sum, 1);
        }

        return count;
    }
}
