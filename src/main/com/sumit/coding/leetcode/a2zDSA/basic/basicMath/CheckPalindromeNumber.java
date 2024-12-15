package com.sumit.coding.leetcode.a2zDSA.basic.basicMath;

public class CheckPalindromeNumber {

    public static void main(String[] args) {
        int N = 4554;
        System.out.println("The Number is - " +
                (new CheckPalindromeNumber().checkPalindrome(N) ? "Palindrome" : "Not Palindrome")
        );
    }

    public boolean checkPalindrome(int N) {
        int reverse = 0;
        int num = N;

        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }

        return reverse == N;
    }
}
