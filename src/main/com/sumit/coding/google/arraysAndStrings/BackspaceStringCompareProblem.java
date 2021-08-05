package main.com.sumit.coding.google.arraysAndStrings;

import java.util.Stack;

/*
 * Problem URL : https://leetcode.com/problems/backspace-string-compare/
 *
 * Input: s = "ab#c", t = "ad#c" Output: true
 * Explanation: Both s and t become "ac".
 * */
public class BackspaceStringCompareProblem {

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(new BackspaceStringCompareProblem().backspaceCompare_approach1(s, t));
        System.out.println(new BackspaceStringCompareProblem().backspaceCompare_approach2(s, t));
    }

    /*
     * Time Complexity : O(M+N)
     * Space Complexity : O(1)
     *
     * M and N are length of S and T respectively.
     * */
    public boolean backspaceCompare_approach2(String S, String T) {
        int sPtr = S.length() - 1, tPtr = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (sPtr >= 0 || tPtr >= 0) {
            while (sPtr >= 0) {
                if (S.charAt(sPtr) == '#') {
                    skipS++;
                    sPtr--;
                } else if (skipS > 0) {
                    skipS--;
                    sPtr--;
                } else
                    break;
            }
            while (tPtr >= 0) {
                if (T.charAt(tPtr) == '#') {
                    skipT++;
                    tPtr--;
                } else if (skipT > 0) {
                    skipT--;
                    tPtr--;
                } else break;
            }

            if (sPtr >= 0 && tPtr >= 0 && S.charAt(sPtr) != T.charAt(tPtr))
                return false;

            if ((sPtr >= 0) != (tPtr >= 0))
                return false;

            sPtr--;
            tPtr--;
        }
        return true;
    }

    /*
     * Time Complexity : O(M+N)
     * Space Complexity : O(M+N)
     *
     * M and N are length of S and T respectively.
     * */
    public boolean backspaceCompare_approach1(String s, String t) {
        return (checkString(s)).equals(checkString(t));
    }

    public String checkString(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch != '#')
                stack.push(ch);
            else if (!stack.isEmpty())
                stack.pop();
        }

        return String.valueOf(stack);
    }
}
