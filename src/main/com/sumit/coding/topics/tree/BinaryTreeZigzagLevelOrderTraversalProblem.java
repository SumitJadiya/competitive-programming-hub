package com.sumit.coding.topics.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversalProblem {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(20));
        root.getRight().setLeft(new TreeNode(15));
        root.getRight().setRight(new TreeNode(7));

        System.out.println(new BinaryTreeZigzagLevelOrderTraversalProblem().zigzagLevelOrder_usingBFS(root));
        System.out.println(new BinaryTreeZigzagLevelOrderTraversalProblem().zigzagLevelOrder_usingDFS(root));
    }

    public List<List<Integer>> zigzagLevelOrder_usingDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        helper(root, 0, res);

        return res;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) return;

        if (res.size() == level) res.add(new ArrayList<>());

        if (level % 2 == 0) res.get(level).add(node.key);
        else res.get(level).add(0, node.key);

        helper(node.left, level+1, res);
        helper(node.right, level+1, res);
    }

    public List<List<Integer>> zigzagLevelOrder_usingBFS(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();

        List<List<Integer>> results = new ArrayList<>();
        boolean reverse = false;
        Queue<TreeNode> st = new LinkedList<>();
        st.add(root);

        while (!st.isEmpty()) {
            int size = st.size();
            List<Integer> l = new ArrayList<>();

            while (size-- > 0) {
                TreeNode temp = st.remove();
                l.add(temp.key);
                if (temp.left != null)
                    st.add(temp.left);
                if (temp.right != null)
                    st.add(temp.right);
            }

            if (reverse) Collections.reverse(l);

            reverse = !reverse;
            results.add(l);
        }

        return results;
    }
}
