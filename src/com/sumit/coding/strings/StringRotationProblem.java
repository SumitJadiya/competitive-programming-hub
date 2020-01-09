package com.sumit.coding.strings;

public class StringRotationProblem {

    public static void main(String[] args) {

        String string1 = "awew";
        String string2 = "ewaw";

        boolean result = StringRotationProblem.checkStringRotatedByTwoPlaces(string1, string2);
        System.out.println("String rotated by two places " + result);

        result = StringRotationProblem.checkStringRotation(string1, string2);
        System.out.println("String is rotated " + result);
    }

    private static boolean checkStringRotation(String string1, String string2) {
        if (string1.length() != string2.length())
            return false;

        String temp = string1.concat(string1);

        return temp.contains(string2);
    }

    private static boolean checkStringRotatedByTwoPlaces(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        if (s1.length() < 2)
            return s1.equals(s2);

        int len = s1.length();

        String temp1 = s1.substring(2) + s1.substring(0, 2);
        String temp2 = s1.substring(len - 2, len) + s1.substring(0, len - 2);

        return temp1.equals(s2) || temp2.equals(s2);
    }
}
