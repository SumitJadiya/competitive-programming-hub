package com.sumit.coding.topics.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Given an integer n, generate all strings with n matching parentheses.
 * "matching" parentheses mean there is equal number of opening and closing parentheses.
 * each opening parenthesis has matching closing parentheses.
 *
 * For example, () is a valid string but )( is not a valid string because ) has no matching parenthesis before it and ( has no matching parenthesis after it.
 *
 * Input
 * n: number of matching parentheses
 * Output
 * all valid strings with n matching parentheses
 *
 * Examples
 * Example 1:
 * Input: n = 2
 * Output: (()) ()()
 *
 * Explanation: There are two ways to create a string with 2 matching parentheses.
 *
 * Example 2:
 * Input: n = 3
 * Output: ((())) (()()) (())() ()(()) ()()()
 *
 * Explanation: There are 5 ways to create a string with 3 matching parentheses.
 *
 * */
public class GenerateAllValidParentheses {

    public static List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0, 0, res, n);
        return res;
    }

    public static void dfs(int startIdx, List<Character> path, int openCount, int closeCount, List<String> res, int n) {
        if (startIdx == 2 * n) {
            res.add(
                    path
                            .stream()
                            .map(Object::toString)
                            .collect(Collectors.joining())
            );
            return;
        }

        if (openCount < n) {
            path.add('(');
            dfs(startIdx + 1, path, openCount + 1, closeCount, res, n);
            path.remove(path.size() - 1);
        }

        if (openCount > closeCount) {
            path.add(')');
            dfs(startIdx + 1, path, openCount, closeCount + 1, res, n);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<String> res = generateParentheses(n);
        res.stream().sorted().forEach(System.out::println);
    }
}
