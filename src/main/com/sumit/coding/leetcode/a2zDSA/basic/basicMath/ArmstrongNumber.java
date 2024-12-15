package com.sumit.coding.leetcode.a2zDSA.basic.basicMath;

public class ArmstrongNumber {

    public static void main(String[] args) {
        int N = 371;

        System.out.println("The number " + N + " is "
                + (new ArmstrongNumber().checkArmstrong(N) ? "" : "not ")
                + "Armstrong Number");
    }

    public boolean checkArmstrong(int N) {
        int len = 0;
        int num = N;

        while (num > 0) {
            num /= 10;
            len++;
        }

        int sum = 0;
        num = N;
        while (num > 0) {
            sum += (int) Math.pow(num % 10, len);
            num/=10;
        }

        return N == sum;
    }
}
