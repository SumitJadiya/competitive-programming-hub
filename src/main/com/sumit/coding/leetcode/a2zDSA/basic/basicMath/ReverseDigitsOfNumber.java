package com.sumit.coding.leetcode.a2zDSA.basic.basicMath;

/*
 * Problem Statement: Given an integer N return the reverse of the given number.
 *
 * Example 1:
 *   Input:N = 12345
 *   Output:54321
 *   Explanation: The reverse of 12345 is 54321.
 * Example 2:
 *   Input:N = 7789
 *   Output: 9877
 *   Explanation: The reverse of number 7789 is 9877.̵
 * */
public class ReverseDigitsOfNumber {

    public static void main(String[] args) {
        int num = 12345;
        System.out.println(new ReverseDigitsOfNumber().reverseNumber(num));

        num = 7789;
        System.out.println(new ReverseDigitsOfNumber().reverseNumber(num));

        num = 10400;
        System.out.println(new ReverseDigitsOfNumber().reverseNumber(num));
    }

    public int reverseNumber(int num) {
        int result = 0;

        while (num > 0) {
            int rem = num % 10;
            result = result * 10 + rem;
            num /= 10;
        }

        return result;
    }
}
