package com.sumit.coding.topics.tree;

/*
 * Problem URL : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * */
public class LCAOfBSTProblem {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(8));
        root.getLeft().setLeft(new TreeNode(0));
        root.getLeft().setRight(new TreeNode(4));
        root.getRight().setLeft(new TreeNode(7));
        root.getRight().setRight(new TreeNode(9));
        root.getLeft().getRight().setLeft(new TreeNode(3));
        root.getLeft().getRight().setRight(new TreeNode(5));

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        System.out.println(TreeNode.print_using_bfs(new LCAOfBSTProblem().lowestCommonAncestor(root, p, q)).get(0).get(0));
        System.out.println(TreeNode.print_using_bfs(new LCAOfBSTProblem().lowestCommonAncestor_recursive(root, p, q)).get(0).get(0));
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.key;
        int qVal = q.key;
        TreeNode node = root;

        while (node != null) {
            int parentVal = node.key;// Value of ancestor/parent node.

            if (pVal > parentVal && qVal > parentVal)
                node = node.right; // If both firstNode and secondNode are greater than parent
            else if (pVal < parentVal && qVal < parentVal)
                node = node.left; // If both firstNode and secondNode are lesser than parent
            else return node;// We have found the split point, i.e. the LCA node.
        }
        return null;
    }


    private TreeNode lowestCommonAncestor_recursive(TreeNode root, TreeNode p, TreeNode q) {
        return recurseTree(root, p, q);
    }

    private TreeNode recurseTree(TreeNode node, TreeNode firstNode, TreeNode secondNode) {
        if (node == null) return node;

        /*
         * If both firstNode and secondNode are less than the current node's value, the LCA must be in the left subtree.
         *
         * If both firstNode and secondNode are greater than the current node's value, the LCA must be in the right subtree.
         *
         * If one of firstNode or secondNode is equal to the current node's value, or if firstNode is less than
         * the current node's value and  secondNode is greater than the current node's value (or vice versa), the current node is the LCA.
         **/

        if (node.key > Math.max(firstNode.key, secondNode.key))
            return recurseTree(node.left, firstNode, secondNode);

        if (node.key < Math.min(firstNode.key, secondNode.key))
            return recurseTree(node.right, firstNode, secondNode);

        return node;
    }
}
