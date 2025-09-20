package com.sumit.coding.topics.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GenerateAllPermutations {

    public static List<String> permutations(String letters) {
        List<String> res = new ArrayList<>();
        dfs(0, letters, new ArrayList<>(), res, new boolean[letters.length()]);
        return res;
    }

    private static void dfs(int startIdx, String letters, List<Character> path, List<String> res, boolean[] used) {

        if (startIdx == letters.length()) {
            res.add(
                    path.stream().map(Object::toString).collect(Collectors.joining())
            );

            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;

            char letter = letters.charAt(i);
            path.add(letter);
            used[i] = true;
            dfs(startIdx + 1, letters, path, res, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String letters = scanner.nextLine();
        scanner.close();
        List<String> res = permutations(letters);
        res.stream().sorted().forEach(System.out::println);
    }
}
