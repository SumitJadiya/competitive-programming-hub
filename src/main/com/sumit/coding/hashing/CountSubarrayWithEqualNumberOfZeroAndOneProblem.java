package main.com.sumit.coding.hashing;

import java.util.HashMap;

public class CountSubarrayWithEqualNumberOfZeroAndOneProblem {
    public int countSubarray(int[] a) {
        int sum = 0;
        int flag = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                a[i] = -1;

            sum = sum + a[i];
            if (sum == 0) {
                flag++;
            }
            if (hm.containsKey(sum)) {
                flag += hm.get(sum);
                hm.put(sum, hm.get(sum) + 1);
            } else
                hm.put(sum, 1);
        }
        return flag;
    }
}
