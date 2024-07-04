package main.com.sumit.coding.topics.stack;

import java.util.Stack;

/*
 * Given a string, s, that may have matched and unmatched parentheses, remove the minimum number of parentheses so that the resulting string represents a valid parenthesization.
 * For example, the string “a(b)” represents a valid parenthesization while the string “a(b” doesn’t, since the opening parenthesis doesn’t have any corresponding closing parenthesis.
 * */
public class MinimumRemoveToMakeValidParenthesesProblem {

    public static String minRemoveParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean[] toRemove = new boolean[s.length()];

        for (int idx = 0; idx < s.length(); idx++) {
            char ch = s.charAt(idx);
            if (ch == '(')
                stack.push(idx);
            else if (ch == ')') {
                if (!stack.isEmpty())
                    stack.pop();
                else
                    toRemove[idx] = true;
            }
        }

        while (!stack.isEmpty())
            toRemove[stack.pop()] = true;

        for (int idx = 0; idx < s.length(); idx++)
            if (!toRemove[idx])
                builder.append(s.charAt(idx));

        return builder.toString();
    }

    public static void main(String[] args) {
        String str = "(";
        String result = "";
        runTestCase(str, result);

        str = "m)no(q)rs(";
        result = "mno(q)rs";
        runTestCase(str, result);

        str = "()";
        result = "()";
        runTestCase(str, result);

        str = ")";
        result = "";
        runTestCase(str, result);

        str = ")(";
        result = "";
        runTestCase(str, result);

        str = "ab)ca(so)(sc(s)(";
        result = "abca(so)sc(s)";
        runTestCase(str, result);

        str = "(((abc)(to)((q)()(";
        result = "(abc)(to)(q)()";
        runTestCase(str, result);
    }

    private static void runTestCase(String input, String expected) {
        int width = 20;
        boolean result = minRemoveParentheses(input).equals(expected);
        System.out.printf("%-" + width + "s%-" + width + "s%n", input, result);
    }
}
