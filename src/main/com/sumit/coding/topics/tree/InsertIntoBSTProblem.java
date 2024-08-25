package com.sumit.coding.topics.tree;

/*
 * Problem URL : https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * */
public class InsertIntoBSTProblem {

    public static void main(String[] args) {
        int val = 5;
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(7));
        root.getLeft().setLeft(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(3));

        System.out.println(TreeNode.print_using_bfs(new InsertIntoBSTProblem().insertIntoBST(root, val)));
    }

    /*
     * Time Complexity : O(N) in worst and O(logN) in avg case
     * Space Complexity : O(N) in worst and O(logN) in avg case
     * */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (root.key < val)
            root.right = insertIntoBST(root.right, val);
        else if (root.key > val)
            root.left = insertIntoBST(root.left, val);

        return root;
    }
}
