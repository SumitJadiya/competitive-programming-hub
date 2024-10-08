package com.sumit.coding.topics.tree;

/*
 * Problem URL : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
 * */
public class ConvertSortedArrayToBSTProblem {
    int[] nums;

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode node = new ConvertSortedArrayToBSTProblem().sortedArrayToBST(nums);
        System.out.println(TreeNode.print_using_bfs(node));
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(logN)
     * */
    public TreeNode helper(int left, int right) {
        if (left > right) return null;

        // always choose left middle node as a root
        int p = (left + right) / 2;

        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }
}
