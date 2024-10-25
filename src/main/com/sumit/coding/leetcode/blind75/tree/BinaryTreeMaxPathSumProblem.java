package com.sumit.coding.leetcode.blind75.tree;

/*
 * Problem URL : https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * */
public class BinaryTreeMaxPathSumProblem {

    int maxSum;

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(-10);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        System.out.println(new BinaryTreeMaxPathSumProblem().maxPathSum(tree));

        TreeNode treeTwo = new TreeNode(1);
        treeTwo.left = new TreeNode(2);
        treeTwo.right = new TreeNode(3);

        System.out.println(new BinaryTreeMaxPathSumProblem().maxPathSum(treeTwo));
    }

    /*
     * Steps to Calculate Maximum Path Sum in a Binary Tree:
     *
     * 1. Check if the root node is null. If so, return 0, as there's no path.
     * 2. Use Depth-First Search (DFS) to traverse each node.
     * 3. Maintain two main variables:
     *    - `leftSum` and `rightSum` to hold the maximum path sum for the left and right subtrees.
     *    - `maxSum` to record the overall maximum path sum encountered so far.
     * 4. For each node:
     *    - Update the maximum path sum by adding the node’s value with the left and right subtree sums.
     *    - Update `maxSum` if this sum exceeds the current `maxSum`.
     * 5. Return the maximum path sum that can be obtained by including the current node and either its left or right child.
     *
     * Time Complexity : O(N), where N is the number of nodes in the tree.
     * Space Complexity : O(H), where H is the height of the tree (due to recursion stack).
     */
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }


    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(0, maxPathSum(root.left));
        int rightSum = Math.max(0, maxPathSum(root.right));

        maxSum = Math.max(root.getKey() + leftSum + rightSum, maxSum);

        return root.key + Math.max(leftSum, rightSum);
    }
}
