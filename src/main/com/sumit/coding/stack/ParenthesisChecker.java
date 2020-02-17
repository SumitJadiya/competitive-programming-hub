package main.com.sumit.coding.stack;

import java.util.Stack;

public class ParenthesisChecker {

    public static void main(String[] args) {
        System.out.println((ispar("{([])}"))?"balanced":"Not Balanced");
        System.out.println((ispar("{(])}"))?"balanced":"Not Balanced");
        System.out.println((ispar("{}"))?"balanced":"Not Balanced");
    }

    static boolean ispar(String x) {

        Stack<Character> stack = new Stack<>();
        boolean result = false;

        for (char c : x.toCharArray()) {

            if (!stack.isEmpty() && ((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}') || (stack.peek() == '[' && c == ']')))
                stack.pop();
            else
                stack.push(c);
        }

        //stack.forEach(System.out::print);

        result = stack.isEmpty();
        return result;
    }
}
