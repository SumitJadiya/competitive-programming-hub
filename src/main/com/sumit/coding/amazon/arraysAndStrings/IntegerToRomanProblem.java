package main.com.sumit.coding.amazon.arraysAndStrings;

/*
 * Problem URL : https://leetcode.com/problems/integer-to-roman/
 * */
public class IntegerToRomanProblem {
    private static final String[] thousands = {"", "M", "MM", "MMM"};
    private static final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    /*
     * Time Complexity : O(1)
     * Space Complexity : O(1)
     * */
    public static String intToRoman(int num) {
        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }

    public static void main(String[] args) {
        int num = 3888;
        System.out.println(intToRoman(num));
    }
}
