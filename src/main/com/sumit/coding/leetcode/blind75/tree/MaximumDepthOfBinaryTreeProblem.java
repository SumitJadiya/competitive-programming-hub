package com.sumit.coding.leetcode.blind75.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem URL : https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * */
public class MaximumDepthOfBinaryTreeProblem {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        System.out.println("Maximum Depth = " + new MaximumDepthOfBinaryTreeProblem().maxDepth(tree));
    }

    /*
     * Steps :
     * 1. Check for null root, return 0 in that case.
     * 2. Initialize a Queue for holding tree nodes, and a variable 'depth' for tracking levels.
     * 3. Perform a BFS, processing nodes level by level:
     *    - Push the children of the current node into the queue.
     *    - Increment 'depth' at each level.
     * 4. Return the final depth.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        return depth;
    }
}
