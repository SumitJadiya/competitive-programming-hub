package com.sumit.coding.stack;

import java.util.Scanner;
import java.util.Stack;

public class GetMinAtPop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 6, 43, 1, 2, 0, 5};

        Stack<Integer> mys = _push(arr, arr.length);
        _getMinAtPop(mys);
        System.out.println();
    }

    public static Stack<Integer> _push(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else if (stack.peek() > arr[i]) {
                stack.push(arr[i]);
            } else
                stack.push(stack.peek());
        }
        return stack;
    }

    static void _getMinAtPop(Stack<Integer> s) {

        while (!s.isEmpty())
            System.out.print(s.pop() + " ");
    }

}
