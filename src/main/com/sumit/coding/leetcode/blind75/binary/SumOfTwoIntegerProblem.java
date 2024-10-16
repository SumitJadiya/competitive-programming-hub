package com.sumit.coding.leetcode.blind75.binary;

public class SumOfTwoIntegerProblem {

    public static void main(String[] args) {
        int firstNumber = 7, secondNumber = 6;
        System.out.println(new SumOfTwoIntegerProblem().getSum(firstNumber, secondNumber));
        firstNumber = 11;
        secondNumber = 8;
        System.out.println(new SumOfTwoIntegerProblem().getSum(firstNumber, secondNumber));
        firstNumber = 9;
        secondNumber = 10;
        System.out.println(new SumOfTwoIntegerProblem().getSum(firstNumber, secondNumber));
        firstNumber = 1;
        secondNumber = 6;
        System.out.println(new SumOfTwoIntegerProblem().getSum(firstNumber, secondNumber));
        firstNumber = 9;
        secondNumber = 4;
        System.out.println(new SumOfTwoIntegerProblem().getSum(firstNumber, secondNumber));
    }

    /*
    * 	Time Complexity: O(log(max(firstNumber, secondNumber)))
	•	Space Complexity: O(1)
    * */
    public int getSum(int firstNumber, int secondNumber) {
        int xorSum = firstNumber ^ secondNumber;
        int andSum = firstNumber & secondNumber;

        while (andSum != 0) {
            int carry = andSum << 1;

            andSum = xorSum & carry;
            xorSum = xorSum ^ carry;
        }

        return xorSum;
    }
}
