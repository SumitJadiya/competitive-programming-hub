package main.com.sumit.coding.strings;

/**
 * URL : https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
 *
 * Approach 1 : Horizontal Scanning [O(S) time , O(1) space]
 *
 * Approach 2 : Vertical Scanning [O(S) time , O(1) space]
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flo","flower","flow","flight"};
        System.out.println("Largest Common Prefix - " + new LongestCommonPrefix().longestCommonPrefix_approach1(strs));
        System.out.println("Largest Common Prefix - " + new LongestCommonPrefix().longestCommonPrefix_approach2(strs));
        System.out.println("Largest Common Prefix - " + new LongestCommonPrefix().longestCommonPrefix_approach2(strs));
    }

    private String longestCommonPrefix_approach2(String[] strs) {

        if(strs.length == 0)
            return "";

        for (int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);

            for (int j=1; j<strs.length; j++){
                if(i==strs[j].length() || c!=strs[j].charAt(i))
                    return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }

    public String longestCommonPrefix_approach1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
