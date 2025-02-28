package com.sumit.coding.leetcode.a2zDSA.basic.basicMath;

public class GcdOrHcfProblem {

    public static void main(String[] args) {
        int firstNum = 9, secondNum = 12;
        System.out.println("GCD/HCF for " + firstNum + " & " + secondNum + ": " + new GcdOrHcfProblem().gcdOrHcf(firstNum, secondNum));
        System.out.println("GCD/HCF for " + firstNum + " & " + secondNum + ": " + new GcdOrHcfProblem().gcdOrHcf_optimised(firstNum, secondNum));
        firstNum = 15;
        secondNum = 20;
        System.out.println("GCD/HCF for " + firstNum + " & " + secondNum + ": " + new GcdOrHcfProblem().gcdOrHcf(firstNum, secondNum));
        System.out.println("GCD/HCF for " + firstNum + " & " + secondNum + ": " + new GcdOrHcfProblem().gcdOrHcf_optimised(firstNum, secondNum));
        firstNum = 12;
        secondNum = 21;
        System.out.println("GCD/HCF for " + firstNum + " & " + secondNum + ": " + new GcdOrHcfProblem().gcdOrHcf(firstNum, secondNum));
        System.out.println("GCD/HCF for " + firstNum + " & " + secondNum + ": " + new GcdOrHcfProblem().gcdOrHcf_optimised(firstNum, secondNum));
    }

    public int gcdOrHcf(int firstNum, int secondNum) {
        for (int i = Math.min(firstNum, secondNum); i > 0; i--)
            if (firstNum % i == 0 && secondNum % i == 0)
                return i;

        return 1;
    }

    public int gcdOrHcf_optimised(int firstNum, int secondNum) {
        if (firstNum == 0 || secondNum == 0) return Math.abs(firstNum - secondNum);
        if (firstNum > secondNum)
            return gcdOrHcf_optimised(firstNum - secondNum, secondNum);

        return gcdOrHcf_optimised(firstNum, secondNum - firstNum);

    }

}
