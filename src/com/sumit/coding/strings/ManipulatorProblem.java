package com.sumit.coding.strings;

// Whenever a ‘#’ is encountered, increment the previously encountered alphabet by 1
public class ManipulatorProblem {
    public static void main(String[] args) {

        String s1 = "Z####";
        String s2 = "#d";

        boolean result = ManipulatorProblem.checkManipulatedString(s1, s2);
        System.out.println("Check Manipulate - " + result);
    }

    private static boolean checkManipulatedString(String s1, String s2) {

        s1 = manipulate(s1.toUpperCase());
        s2 = manipulate(s2.toUpperCase());

        System.out.println("S1 - " + s1 + " S2 - " + s2);
        return s1.equals(s2);
    }

    private static String manipulate(String s) {

        StringBuilder result = new StringBuilder();
        int count = 0;
        char ch;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                count++;
            } else {
                System.out.print(s.charAt(i) + " " + count + " ");
                ch = (char) ((s.charAt(i) - 'A' + count) % 26 + 'A');
                result.append(ch);
                count = 0;
            }
        }

        return result.reverse().toString();
    }
}
