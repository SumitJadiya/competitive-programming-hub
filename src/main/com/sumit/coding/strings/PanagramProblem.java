package main.com.sumit.coding.strings;

import java.util.HashSet;

public class PanagramProblem {

    public static void main(String[] args) {

//        String s1 = "Bawds jog, flick quartz, vex nymph";
        String s1 = "sdfs";
        boolean result = PanagramProblem.checkPanagram(s1.toLowerCase().trim());
        System.out.println(result);
    }

    private static boolean checkPanagram(String s1) {

        boolean result = false;
        HashSet<Character> chars = new HashSet<>();

        for (char ch : s1.toCharArray()) {
            if (Character.isLetter(ch))
                chars.add(ch);
        }

        if (chars.size() == 26)
            result = true;

        return result;
    }
}
