package com.sumit.coding.topics.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(List<Integer> candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        Collections.sort(candidates);
        dfs(candidates, target, res, seq, 0, 0);
        return res;
    }

    public static void dfs(List<Integer> candidates, int target, List<List<Integer>> res, List<Integer> seq, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(seq));
            return;
        }

        if (sum < target) {
            for (int i = start; i < candidates.size(); i++) {
                int candidate = candidates.get(i);
                sum += candidate;

                if (sum > target) break;

                seq.add(candidate);

                dfs(candidates, target, res, seq, sum, i);

                seq.remove(seq.size() - 1);
                sum -= candidate;
            }
        }
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> candidates = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<List<Integer>> res = combinationSum(candidates, target);
        List<List<Integer>> resSorted = new ArrayList<>();
        for (List<Integer> row : res) {
            resSorted.add(row.stream().sorted().collect(Collectors.toList()));
        }
        resSorted.sort((l1, l2) -> {
            for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
                if (l1.get(i) != l2.get(i)) {
                    return l1.get(i) - l2.get(i);
                }
            }
            return l1.size() - l2.size();
        });
        for (List<Integer> row : resSorted) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}

