package com.sumit.coding.topics.tree;

/*
 * Problem URL -- https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 * */
public class KthSmallestElementInBSTProblem {

    private static int count = 0;
    private static int result = 0;

    private static int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private static void inorder(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inorder(node.left, k);

        // Increment count and check if current node is the k-th smallest
        count++;
        if (count == k) {
            result = node.key;
            return;
        }

        inorder(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(18));
        root.getRight().setLeft(new TreeNode(14));
        root.getRight().setRight(new TreeNode(25));

        int k = 2;

        System.out.println(kthSmallest(root, k));
    }
}
