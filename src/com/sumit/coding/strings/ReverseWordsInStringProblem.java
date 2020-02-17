package com.sumit.coding.strings;

public class ReverseWordsInStringProblem {

    public static void main(String[] args) {

        String s1 = "i.like.this.program.very.much";
        String result = ReverseWordsInStringProblem.reverseWords(s1);
        System.out.println("Reversed - " + result);
    }

    private static String reverseWords(String s1) {

        String result = "";
        String[] substrings = s1.split("\\.");

        for (int i = substrings.length - 1; i >= 0; i--)
            result += substrings[i] + ".";

        return result.substring(0, result.length() - 1);
    }
}
