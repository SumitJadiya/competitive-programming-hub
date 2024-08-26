package com.sumit.coding.topics.tree;

public class LCAOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recurseTree(root, p, q);
    }

    private TreeNode recurseTree(TreeNode node, TreeNode firstNode, TreeNode secondNode) {
        if (node == null || node == firstNode || node == secondNode)
            return node;

        TreeNode leftNode = recurseTree(node.left, firstNode, secondNode);
        TreeNode rightNode = recurseTree(node.right, firstNode, secondNode);

        if (leftNode != null && rightNode != null)
            return node;

        return leftNode != null ? leftNode : rightNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode firstNode = new TreeNode(9);
        firstNode.setLeft(new TreeNode(6));
        TreeNode secondNode = new TreeNode(18);

        root.setLeft(firstNode);
        root.setRight(secondNode);

        System.out.println(new LCAOfBinaryTree().lowestCommonAncestor(root, firstNode, secondNode).key);

    }
}
