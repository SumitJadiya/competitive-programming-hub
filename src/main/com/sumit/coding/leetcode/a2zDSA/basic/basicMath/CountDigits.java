package com.sumit.coding.leetcode.a2zDSA.basic.basicMath;

/*
 * Problem Statement: Given an integer N, return the number of digits in N.
 *
 * Example 1:
 * Input:N = 12345
 * Output:5
 * Explanation:  The number 12345 has 5 digits.
 *
 * Example 2:
 * Input:N = 7789
 * Output: 4
 * ̵Explanation: The number 7789 has 4 digits.
 * */
public class CountDigits {

    public static void main(String[] args) {
        int N = 12345;
        System.out.println("countDigit_bruteForce : "+ new CountDigits().countDigit_bruteForce(N));
        System.out.println("countDigit_optimised : " + new CountDigits().countDigit_optimised(N));

        N = 10;
        System.out.println("countDigit_bruteForce : "+ new CountDigits().countDigit_bruteForce(N));
        System.out.println("countDigit_optimised : " + new CountDigits().countDigit_optimised(N));
    }

    public int countDigit_bruteForce(int num) {
        int count = 0;

        while(num>0) {
            count++;
            num/=10;
        }

        return count;
    }

    public int countDigit_optimised(int num) {
        return (int) (Math.log10(num) + 1);
    }

}
