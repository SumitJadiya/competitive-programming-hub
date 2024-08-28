package com.sumit.coding.topics.tree;

public class BinaryTreeMaximumPathSumProblem {

    int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.left.left.left = new TreeNode(6);
        tree.left.left.right = new TreeNode(7);
        System.out.println("Maximum path sum = " + new BinaryTreeMaximumPathSumProblem().maxPathSum(tree));

        tree = new TreeNode(7);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(-1);
        tree.left.right = new TreeNode(-3);
        System.out.println("Maximum path sum = " + new BinaryTreeMaximumPathSumProblem().maxPathSum(tree));
    }

    /**
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        calculatePathSum(root);
        return maxSum;
    }

    /**
     * @param node
     * @return
     */
    public int calculatePathSum(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(calculatePathSum(node.left), 0);
        int right = Math.max(calculatePathSum(node.right), 0);

        maxSum = Math.max(left + right + node.key, maxSum);

        return Math.max(left, right) + node.key;
    }
}
