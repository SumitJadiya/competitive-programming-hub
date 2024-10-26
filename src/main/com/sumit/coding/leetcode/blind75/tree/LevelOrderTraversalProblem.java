package com.sumit.coding.leetcode.blind75.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalProblem {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        System.out.println(new LevelOrderTraversalProblem().levelOrder(tree));
    }

    /*
     * Steps:
     *
     * 1. Return if Empty:
     *    - If `root` is `null`, return an empty list immediately.
     *
     * 2. Initialize Result and Queue:
     *    - Create a `List<List<Integer>> result` to store each level’s nodes.
     *    - Initialize a `Queue<TreeNode>` and add the `root` to it.
     *
     * 3. Traverse Levels:
     *    - Use a `while` loop until the queue is empty:
     *      - Create a list `levelNodes` to hold values at the current level.
     *      - For each node in this level (using `queue.size()`):
     *         - Poll the node, add its value to `levelNodes`.
     *         - Add its left and right children (if non-null) to the queue.
     *      - Add `levelNodes` to `result`.
     *
     * 4. Return Result:
     *    - After processing all levels, return `result`.
     *
     * Complexities:
     * - Time: O(N), where N is the number of nodes (each node is visited once).
     * - Space: O(W), where W is the maximum width of the tree (queue space).
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelNode = new ArrayList<>();
            int levelSize = queue.size();

            while (levelSize > 0) {
                TreeNode node = queue.poll();
                levelNode.add(node.key);

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);

                levelSize--;
            }

            result.add(levelNode);
        }

        return result;
    }
}
