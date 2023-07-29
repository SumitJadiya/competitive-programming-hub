package main.com.sumit.coding.companies.google.treeAndGraph;

/*
 * Problem URL : https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 * */
public class BinaryTreeMaximumPathSumProblem {

    int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new BinaryTreeMaximumPathSumProblem().maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        maxSum(root);

        return maxSum;
    }

    /*
    Steps:
    1. check for edge case [null node]
    2. calculate left and right sum by recursively calling the child nodes
    3. store currSum as the sum of node value, left and right sum
    4. update the max sum if current sum is greater
    5. return the sum of node value and max of left/right node

    Time complexity: O(N), where N is number of nodes, since we visit each node not more than 2 times.

    Space complexity: O(H), where H is a tree height, to keep the recursion stack.
    In the average case of balanced tree, the tree height H = logN, in the worst case of skewed tree, H=N.
    */
    public int maxSum(TreeNode node) {

        if (node == null) return 0;

        int leftSum = Math.max(maxSum(node.left), 0);
        int rightSum = Math.max(maxSum(node.right), 0);

        int currSum = node.val + leftSum + rightSum;

        if (currSum > maxSum) maxSum = currSum;

        return node.val + Math.max(leftSum, rightSum);
    }
}
