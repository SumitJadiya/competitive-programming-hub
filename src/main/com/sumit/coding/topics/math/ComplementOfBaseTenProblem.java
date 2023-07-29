package main.com.sumit.coding.topics.math;

/*
 * Problem URL : https://leetcode.com/problems/complement-of-base-10-integer/
 *
 * Input: n = 10
 * Output: 5
 * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 * */
public class ComplementOfBaseTenProblem {

    public static void main(String[] args) {
        System.out.println(new ComplementOfBaseTenProblem().bitwiseComplement(10));
    }

    public int bitwiseComplement(int n) {
        int m = n;
        int mask = 0;

        // edge case
        if (n == 0) return 1;

        while (m != 0) {
            mask = (mask << 1) | 1;
            m = m >> 1;
        }

        return (~n) & mask;
    }
}
