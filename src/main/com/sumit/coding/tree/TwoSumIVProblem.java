package main.com.sumit.coding.tree;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem URL : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * */
public class TwoSumIVProblem {

    Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(3));
        root.setRight(new TreeNode(6));
        root.getLeft().setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(4));
        root.getRight().setRight(new TreeNode(7));

        int k = 9;

        System.out.println(new TwoSumIVProblem().findTarget(root, k));
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        if (findTarget(root.left, k)) return true;

        if (set.contains(root.key)) return true;

        set.add(k - root.key);

        return findTarget(root.right, k);
    }
}
