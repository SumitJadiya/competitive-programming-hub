package main.com.sumit.coding.leetcode.Oct20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem17 {

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new Problem17().findRepeatedDnaSequences(s));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> freq = new HashMap();

        if(s.length() <= 10) return result;

        for (int i=0; i<=s.length()-10; i++) {

            String substring = s.substring(i, i+10);

            if(freq.containsKey(substring)){
                freq.put(substring, freq.get(substring)+1);

                if(freq.get(substring) == 2 && !result.contains(substring)) result.add(substring);
            }
            else
                freq.put(substring, 1);
        }
        return result;
    }
}

