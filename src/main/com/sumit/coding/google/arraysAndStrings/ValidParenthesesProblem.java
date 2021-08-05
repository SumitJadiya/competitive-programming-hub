package main.com.sumit.coding.google.arraysAndStrings;

import java.util.HashMap;
import java.util.Stack;

/*
 * Problem URL : https://leetcode.com/problems/valid-parentheses/
 * Input: s = "([)]"
 * Output: false
 * */
public class ValidParenthesesProblem {

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     * */
    public static boolean isValid(String s) {

        var stack = new Stack<Character>();
        var hashMap = new HashMap<Character, Character>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');

        for (char c : s.toCharArray()) {
            if (hashMap.containsKey(c)) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != hashMap.get(c)) return false;
            } else
                stack.push(c);
        }

        return stack.isEmpty();
    }

}
