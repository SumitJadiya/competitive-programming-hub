package com.sumit.coding.topics.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Setter
@Getter
public class TreeNode {

    int key;
    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(int x) {
        key = x;
    }

    private static <T> StringBuilder toString(StringBuilder string, TreeNode node) {
        if (node != null) {
            string.append(node.getKey());
            if (node.getLeft() != null) toString(string.append(", "), node.getLeft());
            if (node.getRight() != null) toString(string.append(", "), node.getRight());
        }
        return string;
    }

    public static List<List<Integer>> print_using_bfs(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> innerResult = new ArrayList<>();

            while (levelSize-- > 0) {
                TreeNode node = queue.remove();
                innerResult.add(node.key);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            results.add(innerResult);
        }

        return results;
    }

    public static List<List<Integer>> print_using_bfs_approach_two(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> innerResult = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return result;

        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode value = queue.poll();
            if (value == null) {
                result.add(innerResult);
                innerResult = new ArrayList<>();
                if (!queue.isEmpty())
                    queue.offer(null);
            } else {
                innerResult.add(value.key);
                if (value.left != null)
                    queue.offer(value.left);
                if (value.right != null)
                    queue.offer(value.right);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return toString(new StringBuilder(), this).toString();
    }
}
