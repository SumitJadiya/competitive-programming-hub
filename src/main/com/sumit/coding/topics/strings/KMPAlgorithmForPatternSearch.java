package main.com.sumit.coding.topics.strings;

public class KMPAlgorithmForPatternSearch {

    public static void main(String[] args) {

        final String txt = "ABABDABACDABABCABAB";
        final String pat = "ABABCABAB";

        System.out.print("Pattern found at index -> ");
        KMPAlgorithmForPatternSearch.search(txt, pat);

    }

    private static void search(String txt, String pat) {

        int m = pat.length();
        int n = txt.length();

        int lps[] = new int[m];
        int j = 0;

        computeLPSArray(pat, m, lps);

        int i = 0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println(i - j);
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i += 1;
            }
        }
    }

    private static void computeLPSArray(String pat, int m, int[] lps) {

        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
