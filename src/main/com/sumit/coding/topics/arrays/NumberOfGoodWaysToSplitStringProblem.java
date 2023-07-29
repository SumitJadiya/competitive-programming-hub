package main.com.sumit.coding.topics.arrays;

/*
 * Problem URL : https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 * */
public class NumberOfGoodWaysToSplitStringProblem {

    public static void main(String[] args) {
        String str = "aacaba";
        System.out.println(numSplits(str));
    }

    /*
     * Time Complexity : O(26*N)
     * Space Complexity : O(N)
     * */
    public static int numSplits(String str) {
        int[] l = new int[26];
        int[] r = new int[26];
        int d_l = 0;
        int d_r = 0;
        int res = 0;
        char[] s = str.toCharArray();

        for (char ch : s)
            d_r += ++r[ch - 'a'] == 1 ? 1 : 0;

        for (char c : s) {
            d_l += ++l[c - 'a'] == 1 ? 1 : 0;
            d_r -= --r[c - 'a'] == 0 ? 1 : 0;
            if (d_l > d_r) break;
            res += d_l == d_r ? 1 : 0;
        }
        return res;
    }
}
