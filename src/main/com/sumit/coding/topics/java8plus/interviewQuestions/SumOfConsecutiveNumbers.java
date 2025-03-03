package com.sumit.coding.topics.java8plus.interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class SumOfConsecutiveNumbers {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 5, 19, 2, 10);
        System.out.println(new SumOfConsecutiveNumbers().findConsecutiveNumbers(list));

        list = List.of(1, 5, 19, 2, 10, 20, 30, 40);
        System.out.println(new SumOfConsecutiveNumbers().findConsecutiveNumbers(list));
    }

    public List<Integer> findConsecutiveNumbers(List<Integer> input) {

        if (input.size() == 1) return input;

        int endPtr = 1;
        int maxValue = Integer.MIN_VALUE;

        List<Integer> finalResult = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int sum = input.get(0);
        result.add(input.get(0));

        while (endPtr < input.size() && input.get(endPtr - 1) <= input.get(endPtr)) {
            sum += input.get(endPtr);
            result.add(input.get(endPtr));

            if (maxValue < sum) {
                maxValue = sum;
                finalResult = new ArrayList<>(result);
            }
            endPtr++;

            if (endPtr < input.size() && input.get(endPtr - 1) > input.get(endPtr)) {
                endPtr++;
                sum = input.get(endPtr - 1);
                result = new ArrayList<>();
                result.add(input.get(endPtr - 1));
            }
        }

        return finalResult;
    }
}
