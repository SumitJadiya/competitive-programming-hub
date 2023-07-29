package main.com.sumit.coding.topics.tree;

import static main.com.sumit.coding.topics.tree.TreeNode.print_using_bfs;

/*
 * Problem URL : https://leetcode.com/problems/invert-binary-tree/
 * */
public class InvertTreeProblem {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(7));
        root.getLeft().setLeft(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(3));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(9));

        System.out.println(print_using_bfs(new InvertTreeProblem().invertTree(root)));
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     * */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
