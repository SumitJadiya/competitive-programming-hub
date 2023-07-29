package main.com.sumit.coding.topics.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Substring with Concatenation of All Words
 * Problem URL : https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 */
public class SubstringWithConcatenationOfAllWordsProblem {

    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};

        System.out.println(new SubstringWithConcatenationOfAllWordsProblem().findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> hm1 = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (String str : words)
            hm1.put(str, hm1.getOrDefault(str, 0) + 1);

        int len = words[0].length(), n = words.length;

        for (int st = 0; st <= s.length() - len * n; st++) {
            HashMap<String, Integer> hm2 = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String nstr = s.substring(i * len + st, i * len + st + len);
                if (hm1.containsKey(nstr)) {
                    hm2.put((nstr), hm2.getOrDefault(nstr, 0) + 1);
                    if (hm2.get(nstr) > hm1.get(nstr))
                        break;
                } else
                    break;
            }

            if (hm1.equals(hm2))
                list.add(st);
        }
        return list;
    }
}
