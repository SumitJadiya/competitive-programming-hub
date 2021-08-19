package main.com.sumit.coding.tree;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem URL : https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 *
 * Input: root = [1,null,2,3,4,null,null,5,6]
 * Output: 90
 * Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
 * */
public class MaximumProductOfSplittedBinaryTreeProblem {

    int MOD = (int) (1e9) + 7;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), new TreeNode(4, new TreeNode(5), new TreeNode(6))));
        System.out.println(new MaximumProductOfSplittedBinaryTreeProblem().maxProduct(treeNode));
    }

    /*
     * Time Complexity : O(N)
     * */
    public int maxProduct(TreeNode root) {
        Set<Long> sums = new HashSet<>();
        int total = dfs(root, sums);
        long max = 0;
        for (long sum : sums)
            max = Math.max(max, sum * (total - sum));

        return (int) (max % MOD);
    }

    public int dfs(TreeNode root, Set<Long> sums) {
        if (root == null)
            return 0;
        root.val += dfs(root.left, sums);
        root.val += dfs(root.right, sums);
        sums.add((long) (root.val));
        return root.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
