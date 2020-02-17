package main.com.sumit.coding.strings;

import java.util.Arrays;

public class AnagramProblem {

    public static void main(String[] args) {

        final String string1 = "geeksforgeeks";
        final String string2 = "forgeeksgeeks";

        boolean result = AnagramProblem.checkForAnagram(string1, string2);
        System.out.println(result);
    }

    private static boolean checkForAnagram(String string1, String string2) {

        if (string1.length() != string2.length())
            return false;

        int[] count = new int[256];
        Arrays.fill(count, 0);

        for (int i = 0; i < string1.length(); i++) {
            count[string1.charAt(i)]++;
            count[string2.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] > 0)
                return false;
        }

        return true;
    }

}
