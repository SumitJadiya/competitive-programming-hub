package com.sumit.coding.topics.tree;

/*
 * Problem URL : https://leetcode.com/problems/validate-binary-search-tree/
 * */
public class ValidateBSTProblem {

    private static boolean isValidBST(TreeNode root) {

        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode root, long low, long high) {
        if (root == null)
            return true;
        if (root.key <= low || root.key >= high)
            return false;

        return validate(root.left, low, root.key) && validate(root.right, root.key, high);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(18));
        root.getRight().setLeft(new TreeNode(14));
        root.getRight().setRight(new TreeNode(25));

        System.out.println(isValidBST(root));
    }
}
