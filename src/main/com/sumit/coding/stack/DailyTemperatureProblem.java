package main.com.sumit.coding.stack;

import java.util.Arrays;
import java.util.Stack;

/*
Given a list of daily temperatures temperatures, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature.
If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
* */
public class DailyTemperatureProblem {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

//        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new DailyTemperatureProblem().dailyTemperatures(arr)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < temperatures.length; index++) {
            while (!stack.isEmpty() && temperatures[index] > temperatures[stack.peek()]) {
                int val = stack.pop();
                result[val] = index - val;
            }
            stack.push(index);
        }

        return result;
    }
}
