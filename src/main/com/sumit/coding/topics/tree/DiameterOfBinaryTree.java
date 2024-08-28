package com.sumit.coding.topics.tree;

public class DiameterOfBinaryTree {
    int diameter;

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.left.left.left = new TreeNode(6);
        tree.left.left.right = new TreeNode(7);

        System.out.println("The diameter of given binary tree is : " + new DiameterOfBinaryTree().diameterOfBinaryTree(tree));
    }


    /**
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }

    /**
     * @param node
     * @return
     */
    private int calculateHeight(TreeNode node) {
        if (node == null) return 0;

        int left = calculateHeight(node.left);
        int right = calculateHeight(node.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }
}
