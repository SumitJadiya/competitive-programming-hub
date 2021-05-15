package main.com.sumit.coding.stack;

import java.util.Stack;

/*
 * Problem Statement : https://www.algoexpert.io/questions/Min%20Max%20Stack%20Construction
 * */
public class MinMaxStackProblem {
    public static void main(String[] args) {
        MinMaxStack minStack = new MinMaxStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(5);
        minStack.push(4);
        minStack.pop();
        minStack.pop();
        minStack.push(4);
        minStack.push(11);
        minStack.push(-11);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.push(6);
        System.out.println(minStack.getMin()); // return 6
        minStack.pop();
    }

    static class MinMaxStack {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();
        Stack<Integer> maxStack = new Stack<Integer>();

        public int peek() {
            return (stack.isEmpty()) ? -1 : stack.peek();
        }

        public int pop() {
            if (!stack.isEmpty() && !minStack.isEmpty() && stack.peek().equals(minStack.peek())) minStack.pop();
            if (!stack.isEmpty() && !maxStack.isEmpty() && stack.peek().equals(maxStack.peek())) maxStack.pop();

            return (stack.isEmpty()) ? -1 : stack.pop();
        }

        public void push(Integer number) {
            stack.push(number);

            if (minStack.isEmpty() || minStack.peek() >= number)
                minStack.push(number);

            if (maxStack.isEmpty() || maxStack.peek() <= number)
                maxStack.push(number);
        }

        public int getMin() {
            return (minStack.isEmpty()) ? -1 : minStack.peek();
        }

        public int getMax() {
            return (maxStack.isEmpty()) ? -1 : maxStack.peek();
        }
    }

}

