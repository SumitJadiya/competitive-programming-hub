package main.com.sumit.coding.strings;

import java.util.HashMap;

public class RemoveCommonCharacterAndConcatenateString {

    public static void main(String[] args) {

        String str1 = "aacdb";
        String str2 = "gafd";

        String result = RemoveCommonCharacterAndConcatenateString.removeAndConcat(str1, str2);
        System.out.println("Resultant String - " + result);
    }

    private static String removeAndConcat(String s1, String s2) {

        if (s1.isEmpty() || s2.isEmpty())
            return "-1";

        int i;
        String res = "";

        // creating a hashMap to add characters in string s2
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        for (i = 0; i < s2.length(); i++)
            m.put(s2.charAt(i), 1);

        // Find characters of s1 that are not present in s2 and append to result
        for (i = 0; i < s1.length(); i++)
            if (!m.containsKey(s1.charAt(i)))
                res += s1.charAt(i);
            else
                m.put(s1.charAt(i), 2);

        // Find characters of s2 that are not present in s1.
        for (i = 0; i < s2.length(); i++)
            if (m.get(s2.charAt(i)) == 1)
                res += s2.charAt(i);

        return res;
    }
}
