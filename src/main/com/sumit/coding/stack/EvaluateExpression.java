package main.com.sumit.coding.stack;

import java.util.Stack;

public class EvaluateExpression {

    private static char temp;
    private static int a, b;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        String expression = "+9*26";

        int result = evaluatePrefixExpression(expression);

        if (result == Integer.MIN_VALUE)
            System.out.println("The Expression input is incorrect");
        else
            System.out.println(result);

        expression = "82+5-77+"; // "23+5-"

        result = evaluatePostfixExpression(expression);

        if (result == Integer.MIN_VALUE)
            System.out.println("The Expression input is incorrect");
        else
            System.out.println(result);

    }

    private static int evaluatePostfixExpression(String expression) {

        for (int i = 0; i < expression.length(); i++) {
            temp = expression.charAt(i);
            evaluateExpression(temp);
        }

        if (stack.size() != 1)
            return Integer.MIN_VALUE;

        return stack.pop();
    }

    private static int evaluatePrefixExpression(String expression) {

        for (int i = expression.length() - 1; i >= 0; i--) {
            temp = expression.charAt(i);
            evaluateExpression(temp);
        }

        if (stack.size() != 1)
            return Integer.MIN_VALUE;

        return stack.pop();
    }


    private static void evaluateExpression(char temp) {
        if (Character.isDigit(temp)) {
            stack.push(Character.getNumericValue(temp));
        } else {
            if (!stack.isEmpty())
                a = stack.pop();
            if (!stack.isEmpty())
                b = stack.pop();

            switch (temp) {
                case '+':
                    stack.push(a + b);
                    break;
                case '-':
                    stack.push(b - a);
                    break;
                case '*':
                    stack.push(a * b);
                    break;
                case '/':
                    stack.push(b / a);
                    break;
            }
        }

    }
}
