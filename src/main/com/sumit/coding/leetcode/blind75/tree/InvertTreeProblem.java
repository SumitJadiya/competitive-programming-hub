package com.sumit.coding.leetcode.blind75.tree;

import static com.sumit.coding.leetcode.blind75.tree.TreeNode.print_using_bfs_flatResult;

public class InvertTreeProblem {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(19);
        root.left.right = new TreeNode(12);

        System.out.println(print_using_bfs_flatResult(new InvertTreeProblem().invertTree(root)));
    }

    /*
     * Steps :
     * 1. verify the null check, return the root
     * 2. recursively go to left subtree and right subtree
     * 3. attach the right subtree to left of root and so on. repeat the same process on other side (SWAPPING)
     * 4. return the root
     *
     * Time Complexity: O(N), N: number of nodes
     * Space Complexity: O(H), H: height of tree
     * */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode leftTree = invertTree(root.left);

        root.left = invertTree(root.right);
        root.right = leftTree;

        return root;
    }
}
