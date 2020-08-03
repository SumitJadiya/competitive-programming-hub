package main.com.sumit.coding.strings;

/**
 * URL : https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3411/
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("Marge, let's \"[went].\" I await {news} telegram."));
    }

    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();

        for (char ch : s.toCharArray())
            if(Character.isLetterOrDigit(ch))
                builder.append(Character.toLowerCase(ch));

        return checkPalindrome(builder.toString());
    }

    public boolean checkPalindrome(String s){
        for (int i=0; i<s.length()/2; i++)
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;

        return true;
    }
}
