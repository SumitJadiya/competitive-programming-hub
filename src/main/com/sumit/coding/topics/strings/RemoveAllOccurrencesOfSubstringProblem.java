package main.com.sumit.coding.topics.strings;

/*
 * Remove All Occurrences of a Substring
 * Problem URL : https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
 *
 * Input: s = "daabcbaabcbc", part = "abc"
 * Output: "dab"
 * Explanation: The following operations are done:
 * - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
 * - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
 * - s = "dababc", remove "abc" starting at index 3, so s = "dab".
 * Now s has no occurrences of "abc".
 * */
public class RemoveAllOccurrencesOfSubstringProblem {

    public static void main(String[] args) {
        String s = "aabababa", part = "aba";
        System.out.println(removeOccurrences(s, part));

        s = "axxxxyyyyb";
        part = "xy";
        System.out.println(removeOccurrences(s, part));
    }

    public static String removeOccurrences(String s, String part) {

        while (s.contains(part))
            s = s.replaceFirst(part, "");

        return s;
    }
}
