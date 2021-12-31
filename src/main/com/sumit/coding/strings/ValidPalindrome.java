package main.com.sumit.coding.strings;

/**
 * Valid Palindrome Problem
 * URL : https://leetcode.com/problems/valid-palindrome/
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();

        for (char ch : s.toCharArray())
            if (Character.isLetterOrDigit(ch))
                builder.append(Character.toLowerCase(ch));

        return checkPalindrome(builder.toString());
    }

    /**
    * Check if the string is palindrome
    *
    * Time : O(n), Space : constant
    * */
    public boolean checkPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;

        return true;
    }
}
