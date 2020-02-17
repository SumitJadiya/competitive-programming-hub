package main.com.sumit.coding.stack;

import java.util.Stack;

public class GetMinAtPop {

    public static void main(String[] args) {
        int[] arr = {1, 6, 43, 1, 2, 0, 5};

        Stack<Integer> mys = _push(arr, arr.length);
        _getMinAtPop(mys);
        System.out.println();
    }

    private static Stack<Integer> _push(int[] value, int n) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(value[i]);
            } else if (stack.peek() > value[i]) {
                stack.push(value[i]);
            } else
                stack.push(stack.peek());
        }
        return stack;
    }

    private static void _getMinAtPop(Stack<Integer> s) {

        while (!s.isEmpty())
            System.out.print(s.pop() + " ");
    }

}
