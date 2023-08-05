package main.com.sumit.coding.companies.google.arraysAndStrings;

/*
 * URL - https://leetcode.com/problems/palindromic-substrings/
 * */
public class PalindromicSubstringsProblem {

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(new PalindromicSubstringsProblem().countSubstrings(str));
    }

    public int countSubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); ++i) {
            ans += countPalindromesAroundCenter(s, i, i);

            ans += countPalindromesAroundCenter(s, i, i + 1);
        }

        return ans;
    }

    private int countPalindromesAroundCenter(String ss, int lo, int hi) {
        int ans = 0;

        while (lo >= 0 && hi < ss.length()) {
            if (ss.charAt(lo) != ss.charAt(hi))
                break;

            lo--;
            hi++;

            ans++;
        }

        return ans;
    }
}
