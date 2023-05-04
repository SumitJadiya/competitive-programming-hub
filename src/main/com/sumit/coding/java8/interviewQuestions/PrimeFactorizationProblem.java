package main.com.sumit.coding.java8.interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizationProblem {

    public static void main(String[] args) {
        int num = 160;
        int someNumber = 13;

        System.out.println(" " + new test().findPrimeFactors(num));
        System.out.println(" " + new test().isPrime(someNumber));
    }

    public List<Integer> findPrimeFactors(int num) {
        int squareRootNumber = (int) Math.sqrt(num); // 7
        List<Integer> result = new ArrayList<>();

        for (int idx = squareRootNumber; idx > 1; idx--) {
            while (isPrime(idx) && num % idx == 0) {
                result.add(idx);
                num /= idx;
            }
        }

        return result;
    }

    public boolean isPrime(int someNumber) {
        int squareRootNumber = (int) Math.sqrt(someNumber); // 3

        for (int number = 2; number <= squareRootNumber; number++)
            if (someNumber % number == 0)
                return false;

        return true;
    }
}
