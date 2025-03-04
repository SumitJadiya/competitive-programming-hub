package com.sumit.coding.patterns.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class RepeatedDNASequencesProblem {

    public static void main(String[] args) {
        String dna = "AAAAACCCCCAAAAACCCCCC";
        int k = 9;
        System.out.println(findRepeatedSequences(dna, k));
    }

    public static Set<String> findRepeatedSequences(String dna, int k) {
        Set<String> result = new HashSet<>();
        Set<Integer> seenHashes = new HashSet<>();

        if (dna == null || dna.length() < k || k <= 0)
            return result;

        int[] charValues = new int[128];
        charValues['A'] = 1;
        charValues['C'] = 2;
        charValues['G'] = 3;
        charValues['T'] = 4;
        int base = 4;
        int hash = 0;

        int length = dna.length();
        int power = (int) Math.pow(base, k - 1);

        for (int right = 0; right < k; right++) {
            char ch = dna.charAt(right);
            hash = hash * base + charValues[ch];
        }

        seenHashes.add(hash);

        for (int right = k; right < length; right++) {

            char leftChar = dna.charAt(right - k);
            hash -= charValues[leftChar] * power;

            char rightChar = dna.charAt(right);
            hash = hash * base + charValues[rightChar];

            if (seenHashes.contains(hash)) {
                result.add(dna.substring(right - k + 1, right + 1));
            } else
                seenHashes.add(hash);
        }

        return result;
    }
}
