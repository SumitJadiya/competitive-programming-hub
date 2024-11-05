package com.sumit.coding.leetcode.blind75.tree;

/*
 * Problem URL : https://leetcode.com/problems/subtree-of-another-tree/
 *
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * */
public class SubtreeOfAnotherTreeProblem {

    private final SameTreeProblem sameTreeProblem = new SameTreeProblem();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(new SubtreeOfAnotherTreeProblem().isSubtree(root, subRoot));
    }

    /*
     * Steps :
     *
     * 1. check if both are null, return true as subRoot will be considered as subtree of root
     * 2. check if one of them is null, return false as subRoot isn't matching with root
     * 3. check if the root and subRoot tree is same
     * 4. traverse the tree to left and right
     *
     * Complexity :
     * Time: O(MxN)
     * Space : O(N)
     * */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (sameTreeProblem.isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}