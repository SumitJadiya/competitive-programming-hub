package com.sumit.coding.arrays;

import java.util.ArrayList;

/*
 *
 * Problem URL
 * https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/
 *
 * */

public class FlipProblem {
    public static void main(String[] args) {
        String initialString = "0011";
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(1);
        System.out.println("String after flip - " + afterFlip(initialString));
        System.out.println("String after flip - " + afterFlip(list));
    }

    private static ArrayList<Integer> afterFlip(ArrayList<Integer> list) {
        int intialLength = list.size();
        ArrayList<Integer> res = new ArrayList<>();
        for (int x : list) {
            res.add(0);
        }

        int temp;
        int count = 0;
        boolean flag = false;

        for (int j = 0; j < intialLength; j++) {
            if (res.get(j) != list.get(j)) {
                temp = j;
                while (temp < intialLength) {
                    res.set(temp, flipBits(res.get(temp)));
                    temp++;
                    flag = true;
                }

                if (flag) {
                    count++;
                    flag = false;
                }
            }
        }

        System.out.println("Total Count = " + count);
        return res;
    }

    private static Integer flipBits(int x) {
        return (x == 0 ? 1 : 0);
    }

    private static String afterFlip(String intialString) {

        int intialLength = intialString.length();
        StringBuilder res = new StringBuilder();
        for (char x : intialString.toCharArray()) {
            res.append("0");
        }

        int temp;
        int count = 0;
        boolean flag = false;

        for (int j = 0; j < intialLength; j++) {
            if (res.charAt(j) != intialString.charAt(j)) {
                temp = j;
                while (temp < intialLength) {
                    res.setCharAt(temp, flipBits(res.charAt(temp)));
                    temp++;
                    flag = true;
                }

                if (flag) {
                    count++;
                    flag = false;
                }

            }
        }

        System.out.println("Total Count = " + count);

        return res.toString();
    }

    private static char flipBits(char x) {
        return (x == '0' ? '1' : '0');
    }
}
