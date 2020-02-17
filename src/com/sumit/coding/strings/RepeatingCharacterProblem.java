package com.sumit.coding.strings;

public class RepeatingCharacterProblem {
    public static void main(String[] args) {

        String str = "geeksforgeeks";

        int result = RepeatingCharacterProblem.firstAppearanceLeftmost(str);
        System.out.println("Index of leftMost repeating character is - " + result);

        result = RepeatingCharacterProblem.nonRepeatingCharacter(str);
        System.out.println("Index of leftMost non repeating character is - " + result);

        char max = RepeatingCharacterProblem.maxOccuringCharacter(str);
        System.out.println("Max Occurring Character - " + max);
    }

    private static int firstAppearanceLeftmost(String str) {

        int len = str.length();
        int[] count = new int[26];
        int result = -1;

        for (int i = len - 1; i >= 0; i--) {
            if (++count[str.charAt(i) - 'a'] > 1)
                result = i;
        }
        return result;
    }

    private static int nonRepeatingCharacter(String str) {

        int len = str.length();
        int[] count = new int[26];
        int result = -1;

        for (int i = len - 1; i >= 0; i--) {
            count[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            if (count[str.charAt(i) - 'a'] == 1) {
                result = i;
                break;
            }
        }

        return result;
    }

    private static char maxOccuringCharacter(String str) {

        int len = str.length();
        int[] count = new int[256];
        char result = 'a';
        int max = Integer.MIN_VALUE;

        for (int i = len - 1; i >= 0; i--) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {

            if (count[i] > max) {
                result = (char) i;
                max = count[i];
            }
        }

        return result;
    }
}
