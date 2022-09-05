package main.com.sumit.coding.math;

/*
 * Problem URL : https://leetcode.com/problems/power-of-two/
 *
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 * */
public class PowerOfTwoProblem {

    public static void main(String[] args) {
        System.out.println(new PowerOfTwoProblem().isPowerOfTwo(16));
    }

    public boolean isPowerOfTwo(int n) {

        if (n < 0) return false;
        int count = 0;
        while (n != 0) {
            int bit = n & 1;
            if (bit == 1) count++;

            n = n >> 1;
        }

        return (count == 1);
    }
}
