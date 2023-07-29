package main.com.sumit.coding.companies.google.arraysAndStrings;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 *
 * Input: time = "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
 * It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * */
public class NextClosestTimeProblem {

    public static void main(String[] args) {
        String time = "19:34";
        System.out.println(new NextClosestTimeProblem().nextClosestTime(time));
    }

    /*
     * Time complexity : O(N)
     * Space Complexity : O(1)
     * */
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();

        for (char c : time.toCharArray())
            set.add(c - '0');

        int mins = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));

        while (true) {
            mins++;

            if (mins == 24 * 60) mins = 0;

            int H = (mins / 60) / 10;
            int h = (mins / 60) % 10;

            int M = (mins % 60) / 10;
            int m = (mins % 60) % 10;

            if (!set.contains(H) || !set.contains(h) || !set.contains(M) || !set.contains(m)) continue;

            return H + "" + h + ":" + M + "" + m;
        }
    }
}
