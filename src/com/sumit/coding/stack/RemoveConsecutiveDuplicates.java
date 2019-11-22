package com.sumit.coding.stack;

import java.io.IOException;
import java.util.Stack;

public class RemoveConsecutiveDuplicates {
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        System.out.println(removeConsecutiveDuplicates("aaaaaabaabccccccc"));
        System.out.println(removePair("aaaaaababccccccc"));
    }

    // Function to print string after removing consecutive duplicates
    public static String removeConsecutiveDuplicates(String str) {

        for (char c : str.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c)
                stack.push(c);
        }

        // stack.forEach(System.out::print);
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }

    public static String removePair(String str){


        for (char c : str.toCharArray()){

            if(stack.isEmpty() || stack.peek()!=c)
                stack.push(c);
            else if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }
}
