package com.sumit.coding.leetcode.blind75.tree;

/*
 * Problem URL : https://leetcode.com/problems/same-tree/
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * */
public class SameTreeProblem {

    public static void main(String[] args) {

        TreeNode treeOne = new TreeNode(3);
        treeOne.left = new TreeNode(9);
        treeOne.right = new TreeNode(20);

        TreeNode treeTwo = new TreeNode(3);
        treeTwo.left = new TreeNode(9);
        treeTwo.right = new TreeNode(20);

        System.out.println(new SameTreeProblem().isSameTree(treeOne, treeTwo));
    }

    /*
     * Steps :
     * 1. check if both are null, return true as both are same
     * 2. check if one of the node is null, return false as both are different
     * 3. compare the keys of both the nodes and recursively compare left with left and right with right.
     *
     * Time Complexity : O(N), N : Node of the tree
     * Space Complexity : O(H), H : height of the tree
     * */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        return p.getKey() == q.getKey() && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
