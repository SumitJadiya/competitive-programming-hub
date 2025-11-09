package com.sumit.coding.topics.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SubsetsProblem {
    public static List<List<Integer>> subsets_v1(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs_v1(0, new ArrayList<>(), nums, res);
        return res;
    }

    public static void dfs_v1(int i, List<Integer> cur, List<Integer> nums, List<List<Integer>> res) {
        if (i == nums.size()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums.get(i));
        dfs_v1(i + 1, cur, nums, res);
        cur.remove(cur.size() - 1);
        dfs_v1(i + 1, cur, nums, res);
    }

    public static void dfs_v2(int i, List<Integer> cur, List<Integer> nums, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        for (int num_idx = i; num_idx < nums.size(); ++num_idx) {
            cur.add(nums.get(num_idx));
            dfs_v2(num_idx + 1, cur, nums, res);
            cur.remove(cur.size() - 1);
        }
    }
    public static List<List<Integer>> subsets_v2(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs_v2(0, new ArrayList<>(), nums, res);
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3);
        long start = System.nanoTime();

        List<List<Integer>> res = subsets_v2(nums);
        long end = System.nanoTime();

        System.out.println(end - start);

        List<List<Integer>> resSorted = new ArrayList<>();
        for (List<Integer> row : res) {
            resSorted.add(row.stream().sorted().collect(Collectors.toList()));
        }
        resSorted.sort((l1, l2) -> {
            for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
                if (!Objects.equals(l1.get(i), l2.get(i))) {
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

