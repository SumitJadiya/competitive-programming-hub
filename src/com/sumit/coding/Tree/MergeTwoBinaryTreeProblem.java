package com.sumit.coding.Tree;

// TODO : Correct this problem
public class MergeTwoBinaryTreeProblem {
    public static void main(String[] args) {

        MergeTwoBinaryTreeProblem mergeTwoBinaryTreeProblem = new MergeTwoBinaryTreeProblem();

        TreeNode t1 = new TreeNode(1);
        t1.setLeft(new TreeNode(3));
        t1.setRight(new TreeNode(2));
        t1.getLeft().setLeft(new TreeNode(5));

        TreeNode t2 = new TreeNode(2);
        t1.setLeft(new TreeNode(1));
        t1.setRight(new TreeNode(3));
        t1.getLeft().setRight(new TreeNode(4));
        t1.getRight().setRight(new TreeNode(7));

        TreeNode result = mergeTwoBinaryTreeProblem.mergeTrees(t1, t2);
        mergeTwoBinaryTreeProblem.inorder(result);
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;

        /* first recur on left child */
        inorder(node.left);

        /* then print the data of node */
        System.out.printf("%d ", node.key);

        /* now recur on right child */
        inorder(node.right);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode result = new TreeNode(t1.key + t2.key);
        result.left = mergeTrees(t1.left, t2.left);
        result.right = mergeTrees(t1.right, t2.right);
        return result;
    }
}
