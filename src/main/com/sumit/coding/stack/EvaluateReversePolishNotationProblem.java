package main.com.sumit.coding.stack;

import java.util.Stack;

public class EvaluateReversePolishNotationProblem {

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvaluateReversePolishNotationProblem().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        int index = 0;
        int result = 0;
        int firstVal = 0;
        int secondVal = 0;
        Stack<Integer> stack = new Stack<>();

        while (index < tokens.length) {
            String token = tokens[index];

            if (!token.matches("-?\\d+(\\.\\d+)?")) {
                firstVal = (stack.isEmpty()) ? 0 : stack.pop();
                secondVal = (stack.isEmpty()) ? 0 : stack.pop();
            }

            switch (token) {
                case "*":
                    stack.push(firstVal * secondVal);
                    break;
                case "-":
                    stack.push(secondVal - firstVal);
                    break;
                case "+":
                    stack.push(firstVal + secondVal);
                    break;
                case "/":
                    stack.push(secondVal / firstVal);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
            index++;
        }
        result = (stack.isEmpty()) ? 0 : stack.pop();

        return result;
    }

}
