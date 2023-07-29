package main.com.sumit.coding.topics.stack;

import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] a = {100, 80, 60, 70, 60, 75, 85, 10, 4, 5, 90, 120, 80};
        int n = a.length;
        int[] s = new int[n];

        new StockSpanProblem().calculateSpan(a, n, s);

        for (int i = 0; i < n; i++) {
            System.out.print(s[i] + " ");
        }
    }

    private void calculateSpan(int[] price, int n, int[] S) {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        S[0] = 1;

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && (price[stack.peek()] <= price[i]))
                stack.pop();

            S[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
    }
}
