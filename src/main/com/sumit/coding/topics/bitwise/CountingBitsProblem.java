package main.com.sumit.coding.topics.bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * URL - https://leetcode.com/problems/counting-bits
 * */
public class CountingBitsProblem {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(new CountingBitsProblem().countBits(n)));

        n = 20;
        System.out.println(Arrays.toString(new CountingBitsProblem().countBits_secondApproach(n)));
    }

    public int[] countBits(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            list.add(count1s(i));

        return list.parallelStream().mapToInt(i -> i).toArray();
    }

    public int count1s(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >>> 1;
        }

        return count;
    }

    public int[] countBits_secondApproach(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++)
            ans[i] = ans[i & (i - 1)] + 1;

        return ans;
    }
}
