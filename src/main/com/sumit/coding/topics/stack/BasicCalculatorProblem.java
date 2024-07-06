package main.com.sumit.coding.topics.stack;

import java.util.Stack;

/*
 * Given a string containing an arithmetic expression, implement a basic calculator that evaluates the expression string.
 * The expression string can contain integer numeric values and should be able to handle the “+” and “-” operators, as well as “()” parentheses.
 *
 * Note: We'll evaluate the expression in the following sequence:
 * 1) Convert consecutive digits into a single operand.
 * 2) Handle "+", "-" operators.
 * 3) Handle the "(" bracket.
 * 4) Handle the ")" bracket.
 *
 * Algorithm Steps:
 *
 * Traverse the expression character by character.
 * - If the character is a digit, construct the number.
 * - If the character is + or -, update the result with the current number and reset the number, also update the sign.
 * - If the character is (, push the current result and sign onto the stack and reset them.
 * - If the character is ), update the result with the current number and sign, then pop the top of the stack (which represents the result before the parenthesis) and add the current result to it. Adjust the sign accordingly.
 * */
public class BasicCalculatorProblem {
    public static void main(String[] args) {
        String expression = "1+1";
//        System.out.println(calculator(expression));
//
//        expression = "2-1+2";
//        System.out.println(calculator(expression));

        expression = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculator(expression));
    }

    public static int calculator(String expression) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int sign = 1; // 1 means positive, -1 means negative
        int result = 0;

        for (int idx = 0; idx < expression.length(); idx++) {
            char ch = expression.charAt(idx);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            } else if (ch == '-' || ch == '+') {
                result += sign * number;
                number = 0;
                sign = ch == '-' ? -1 : 1;
            }
        }

        if (number != 0) result += sign * number;

        return result;
    }
}
