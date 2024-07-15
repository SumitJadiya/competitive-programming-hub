package main.com.sumit.coding.algorithms.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * You’re given an array of positive integers, weights, where weights[i] is the weight of the i th index.
 * Write a function, Pick Index(), which performs weighted random selection to return an index from the weights array.
 * The larger the value of weights[i], the heavier the weight is, and the higher the chances of its index being picked.
 *
 * Suppose that the array consists of the weights [12,84,35]. In this case, the probabilities of picking the indexes will be as follows:
 *
 * Index 0: 12/(12+84+35)=9.2%
 * Index 1: 84/(12+84+35)=64.1%
 * Index 2: 35/(12+84+35)=26.7%
 *
 * Constraints:
 * 1 ≤ weights.length ≤ 10^4
 * 1 ≤ weights[i] ≤10^5
 * Pick Index() will be called at most 10^4 times.
 * */
public class RandomPickWithWeightsProblem {

    int[] runningSums;
    private final int totalSum;

    public RandomPickWithWeightsProblem(int[] weights) {
        int runningSum = 0;
        runningSums = new int[weights.length];

        for (int i = 0; i < weights.length; i++) {
            runningSum += weights[i];
            runningSums[i] = runningSum;
        }

        totalSum = runningSum;
    }

    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(totalSum) + 1;
        int low = 0;
        int high = runningSums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target > runningSums[mid])
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public static int sumW(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum = sum + arr[i];

        return sum;
    }

    static float round(float var) {
        float value = (int) (var * 100 + .5);
        return value / 100;
    }

    public static void main(String[] args) {
        int counter = 900;
        int[] weights1 = {1, 2, 3, 4, 5};
        int[] weights2 = {1, 12, 23, 34, 45, 56, 67, 78, 89, 90};
        int[] weights3 = {10, 20, 30, 40, 50};
        int[] weights4 = {1, 10, 23, 32, 41, 56, 62, 75, 87, 90};
        int[] weights5 = {12, 20, 35, 42, 55};
        int[] weights6 = {10, 10, 10, 10, 10};
        int[] weights7 = {10, 10, 20, 20, 20, 30};
        int[] weights8 = {1, 2, 3};
        int[] weights9 = {10, 20, 30, 40};
        int[] weights10 = {5, 10, 15, 20, 25, 30};
        int[][] weights = {weights1, weights2, weights3, weights4, weights5,
                weights6, weights7, weights8, weights9, weights10};

        HashMap<Integer, Integer> dict = new HashMap<>();

        for (int i = 0; i < weights.length; i++) {
            System.out.println((i + 1) + ".\tInput: " + Arrays.toString(weights[i]) + ", pickIndex() called " + counter + " times" + "\n");
            for (int l = 0; l < weights[i].length; l++) {
                dict.put(l, 0);
            }
            for (int j = 0; j < counter; j++) {
                RandomPickWithWeightsProblem sol = new RandomPickWithWeightsProblem(weights[i]);
                int index = sol.pickIndex();
                dict.put(index, dict.get(index) + 1);
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println("Indexes\t" + "|" + "\tWeights\t   " + "|" + "\t   Occurences  \t" + "|" + "\tFrequency\t" + "|" + "\tExpected Frequency");
            System.out.println(new String(new char[100]).replace('\0', '-'));
            for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
                System.out.println(entry.getKey() + "\t|\t" + weights[i][entry.getKey()] + "\t   | \t" + dict.get(entry.getKey()) + "\t\t|\t" + round(dict.get(entry.getKey()) / (float) counter) * 100 + "%" + "\t\t|\t" + round(weights[i][entry.getKey()] / (float) sumW(weights[i]) * 100) + "%");
            }
            dict.clear();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
