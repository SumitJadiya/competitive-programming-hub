package main.com.sumit.coding.google.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem URL : https://leetcode.com/problems/generate-parentheses
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * */
public class GenerateParenthesisProblem {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new GenerateParenthesisProblem().generateParenthesis(n));
    }

    /*
     * Time Complexity : O(4^n / sqrt(n))
     * Space Complexity : O(4^n / sqrt(n))
     * Each valid sequence has at most n steps during the backtracking procedure
     * */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0)
            ans.add("");
        else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}
