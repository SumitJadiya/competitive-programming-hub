package main.com.sumit.coding.strings;

/**
 * Problem : Valid Palindrome II
 *
 * URL : https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 */
public class ValidPalindromeIIProblem {

    public static void main(String[] args) {

        String str = "aba";
        System.out.println(new ValidPalindromeIIProblem().validPalindrome(str));
    }

    private boolean validPalindrome(String str) {
        int len = str.length();
        int leftPtr = 0;
        int rightPtr = len - 1;

        while (leftPtr < rightPtr) {
            if (str.charAt(leftPtr) != str.charAt(rightPtr))
                return checkPalindrome(str, leftPtr + 1, rightPtr) || checkPalindrome(str, leftPtr, rightPtr - 1);

            leftPtr++;
            rightPtr--;
        }

        return true;
    }

    /**
     * Util method to check palindrome
     *
     * Time Complexity: O(N), Space : Constant
     * */
    private boolean checkPalindrome(String str, int leftPtr, int rightPtr) {
        while (leftPtr < rightPtr) {
            if (str.charAt(leftPtr) != str.charAt(rightPtr)) return false;

            leftPtr++;
            rightPtr--;
        }

        return true;
    }
}
