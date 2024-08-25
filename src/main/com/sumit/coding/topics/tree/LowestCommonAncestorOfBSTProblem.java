package com.sumit.coding.topics.tree;

/*
 * Problem URL : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * */
public class LowestCommonAncestorOfBSTProblem {

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

        System.out.println(TreeNode.print_using_bfs(new LowestCommonAncestorOfBSTProblem().lowestCommonAncestor(root, p, q)).get(0).get(0));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.key;
        int qVal = q.key;
        TreeNode node = root;

        while (node != null) {
            int parentVal = node.key;// Value of ancestor/parent node.

            if (pVal > parentVal && qVal > parentVal)
                node = node.right; // If both p and q are greater than parent
            else if (pVal < parentVal && qVal < parentVal)
                node = node.left; // If both p and q are lesser than parent
            else
                return node;// We have found the split point, i.e. the LCA node.
        }
        return null;
    }

}
