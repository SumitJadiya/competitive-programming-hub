package main.com.sumit.coding.companies.google.InterviewProcess;

/*
 * Problem URL :
 * https://leetcode.com/problems/license-key-formatting/
 *
 * Input: s = "5F3Z-2e-9-w", k = 4
 * Output: "5F3Z-2E9W"
 * Explanation: The string s has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 *
 * Solution : O(N)
 * */
public class LicenseKeyFormattingProblem {

    public static void main(String[] args) {
        String s = "5F3Z-2e-9-w";
        int k = 4;
        System.out.println(licenseKeyFormatting(s, k));
    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '-') continue;

            if (count == k) {
                sb.append("-");
                count = 0;
            }

            sb.append(Character.toUpperCase(s.charAt(i)));
            count++;
        }

        return sb.reverse().toString();
    }
}
