package com.sumit.coding.topics.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class TernaryTreePathsProblem {
    public static class Node<T> {
        public T val;
        public List<Node<T>> children;

        public Node(T val) {
            this(val, new ArrayList<>());
        }

        public Node(T val, List<Node<T>> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static List<String> ternaryTreePaths(Node<Integer> root) {
        List<String> res = new ArrayList<>();

        if (root == null) return res;
        dfs(root, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(Node<Integer> root, List<String> path, List<String> res) {
        path.add(String.valueOf(root.val));

        if (root.children.isEmpty()) {
            res.add(String.join("->", path));

        } else {
            for (Node<Integer> child : root.children) {
                List<String> pathCopy = new ArrayList<>(path);
                if (child != null) {
                    dfs(child, pathCopy, res);
                }
            }
        }
    }

    // Space Efficient Solution
    private static void dfs_v2 (Node<Integer> root, List<String> path, List<String> res) {
        path.add(String.valueOf(root.val));

        if(root.children.isEmpty()) {
            res.add(String.join("->", path));
        } else {
            for(Node<Integer> child : root.children) {
                if (child != null) {
                    dfs(child, path, res);
                }
            }
        }

        path.remove(path.size() - 1);
    }

    // this function builds a tree from input; you don't have to modify it
    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        int num = Integer.parseInt(iter.next());
        ArrayList<Node<T>> children = new ArrayList<>();
        for (int i = 0; i < num; i++)
            children.add(buildTree(iter, f));
        return new Node<T>(f.apply(val), children);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        String input = "1 3 2 1 5 0 3 0 4 0";
        Node<Integer> root = buildTree(splitWords(input).iterator(), Integer::parseInt);
        List<String> res = ternaryTreePaths(root);
        for (String line : res)
            System.out.println(line);
    }
}
