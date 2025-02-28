package com.sumit.coding.leetcode.a2zDSA.basic.basicMath;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.List;

public class DivisorOfNumber {

    public static void main(String[] args) {
        int number = 36;
        System.out.println(allDivisors(number));
    }

    public static List<Integer> allDivisors(int number) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = number; i > 0; i--) {
            if (number % i == 0)
                divisors.add(i);
        }

        return divisors;
    }
}
