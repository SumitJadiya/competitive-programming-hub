package main.com.sumit.coding.google.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 1st Problem URL : https://leetcode.com/problems/strobogrammatic-number/
 * Input: num = "69"
 * Output: true
 *
 * 2nd Problem URL : https://leetcode.com/problems/strobogrammatic-number-ii/
 * Input: n = 2
 * Output: ["11","69","88","96"]
 * */
public class StrobogrammaticNumberProblem {

    List<String> list;
    Map<Character, Character> hm = new HashMap<>(Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6'));

    public static void main(String[] args) {
        /* First Problem */
        String num = "69";
        System.out.println(new StrobogrammaticNumberProblem().isStrobogrammatic(num));

        /* Second Problem */
        int n = 1;
        System.out.println(new StrobogrammaticNumberProblem().findStrobogrammatic(n));
    }

    /*
     * Time Complexity : O(N) : depends on the length of nums
     * Space Complexity : O(1) : const space
     * */
    public boolean isStrobogrammatic(String num) {

        for (int left = 0, right = num.length() - 1; left < right; left++, right--) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            if (!hm.containsKey(leftChar) && hm.get(leftChar) != rightChar) return false;
        }
        return true;
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     * */
    public List<String> findStrobogrammatic(int n) {
        list = new ArrayList<>();
        if (n == 0) return list;
        char[] ch = new char[n];
        helper(ch, 0, n - 1, list);
        return list;
    }

    private void helper(char[] ch, int left, int right, List<String> list) {
        if (left > right) {
            if (ch.length == 1 || ch[0] != '0')
                list.add(String.valueOf(ch));
            return;
        }

        for (char item : hm.keySet()) {
            if (left == right && item != hm.get(item)) continue;

            ch[left] = item;
            ch[right] = hm.get(item);
            helper(ch, left + 1, right - 1, list);
        }
    }
}
