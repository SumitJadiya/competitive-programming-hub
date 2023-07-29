package main.com.sumit.coding.companies.google.treeAndGraph;

import java.util.HashSet;
import java.util.Set;

/*
 * Input: n = 2, k = 2
 * Output: "01100"
 * Explanation: "01100", "10011", "11001" will be accepted too.
 * */
public class CrackingTheSafeProblem {

    int K;
    int N;
    String res;
    int maxCombination = 1;

    public static void main(String[] args) {
        System.out.println(new CrackingTheSafeProblem().crackSafe(2, 2));
    }

    public String crackSafe(int n, int k) {
        this.N = n;
        this.K = k;
        for (int i = 0; i < n; i++)
            maxCombination *= k;

        crackSafeHelper("", new HashSet<>());
        return res;
    }

    public boolean crackSafeHelper(String prefix, Set<String> allCombs) {
        if (prefix.length() >= N && allCombs.contains(prefix.substring(prefix.length() - N)))
            return false;
        if (prefix.length() >= N) allCombs.add(prefix.substring(prefix.length() - N));
        if (allCombs.size() >= maxCombination) {
            res = prefix;
            return true;
        }

        for (int i = 0; i < K; i++)
            if (crackSafeHelper(prefix + String.valueOf(i), allCombs)) return true;

        if (prefix.length() >= N) allCombs.remove(prefix.substring(prefix.length() - N));
        return false;
    }
}
