package main.com.sumit.coding.topics.math;

public class DivisibleByNumberProblem {
    public static void main(String[] args) {

        int n = 200;

        System.out.println("Total number of integers divisible by 3 and 5 are - " + (n / 3 + n / 5 - n / (3 * 5)));
    }
}
