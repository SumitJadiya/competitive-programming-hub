package main.com.sumit.coding.companies.google.arraysAndStrings;

/*
 * Problem URL : https://leetcode.com/problems/find-and-replace-in-string/
 * Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
 * Output: "eeebffff"
 * Explanation: "a" occurs at index 0 in s, so we replace it with "eee". "cd" occurs at index 2 in s, so we replace it with "ffff".-
 * */
public class FindAndReplaceInStringProblem {

    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};

        System.out.println(findReplaceString(s, indices, sources, targets));
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     * */
    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        int[] map = new int[S.length()];
        for (int i = 0; i < indexes.length; i++)
            map[indexes[i]] = i + 1;

        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < S.length()) {
            char ch = S.charAt(i);
            if (map[i] == 0) {
                builder.append(ch);
                i++;
                continue;
            }

            int index = map[i] - 1;
            String src = sources[index];
            String sub = S.substring(i, i + src.length());
            if (!sub.equals(src)) {
                builder.append(ch);
                i++;
                continue;
            }

            builder.append(targets[index]);
            i += src.length();
        }

        return builder.toString();
    }
}


