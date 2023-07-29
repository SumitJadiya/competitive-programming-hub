package main.com.sumit.coding.topics.stack;

import java.util.LinkedList;

/**
 * Remove K Digits
 * Problem URL : https://leetcode.com/problems/remove-k-digits/
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 */
public class RemoveKDigitsProblem {

    public static void main(String[] args) {
        int k = 3;
        String num = "1432219";

        System.out.println(new RemoveKDigitsProblem().removeKdigits(num, k));
    }

    /**
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char digit : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        for (int i = 0; i < k; ++i)
            stack.removeLast();

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }
}
