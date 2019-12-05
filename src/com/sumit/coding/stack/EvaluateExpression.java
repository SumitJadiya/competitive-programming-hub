package com.sumit.coding.stack;

import java.util.Stack;

public class EvaluateExpression {

    private static char temp;
    private static int a, b;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        String expression = "+9*26";
        System.out.println(evaluatePrefixExpression(expression));

        expression = "231*+9-";
        System.out.println(evaluatePostfixExpression(expression));
    }

    private static int evaluatePostfixExpression(String expression) {

        for (int i = 0; i < expression.length(); i++) {
            temp = expression.charAt(i);
            evaluateExpression(temp);
        }

        return stack.pop();
    }

    private static int evaluatePrefixExpression(String expression) {

        for (int i = expression.length() - 1; i >= 0; i--) {
            temp = expression.charAt(i);
            evaluateExpression(temp);
        }

        return stack.pop();
    }


    private static void evaluateExpression(char temp) {
        if (Character.isDigit(temp)) {
            stack.push(Character.getNumericValue(temp));
        } else {
            a = stack.pop();
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
