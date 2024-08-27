package com.sumit.coding.topics.tree;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.left.left.left = new TreeNode(6);
        tree.left.left.right = new TreeNode(7);

        System.out.println("The diameter of given binary tree is : " + diameterOfBinaryTree(tree));
    }


    /**
     * @param root
     * @return
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        calculateHeight(root, diameter);
        return diameter[0];
    }

    /**
     * @param node
     * @param diameter
     * @return
     */
    private static int calculateHeight(TreeNode node, int[] diameter) {
        if (node == null) return 0;

        int left = calculateHeight(node.left, diameter);
        int right = calculateHeight(node.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return Math.max(left, right) + 1;
    }
}
