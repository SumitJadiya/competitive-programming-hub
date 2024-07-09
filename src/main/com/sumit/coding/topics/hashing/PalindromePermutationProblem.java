package main.com.sumit.coding.topics.hashing;

import java.util.HashMap;
import java.util.Map;

/*
 * For a given string, st, find whether a permutation of this string is a palindrome.
 * You should return TRUE if such a permutation is possible and FALSE if it isn’t possible.
 * */
public class PalindromePermutationProblem {

    public static boolean permutePalindrome(String st) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : st.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        int oddCount = 0;
        for (int frequency : map.values()) {
            if (frequency % 2 != 0)
                oddCount++;

            if (oddCount > 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String st = "abab";
        System.out.println(permutePalindrome(st));

        st = "peas";
        System.out.println(!permutePalindrome(st));
    }
}
