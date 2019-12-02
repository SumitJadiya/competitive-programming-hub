package com.sumit.coding.Tree;

import java.util.Map;
import java.util.TreeMap;

class TreeNode {

    private int key;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

// Class for Binary Tree
class Tree {

    private TreeNode root;

    public Tree() {
    }

    public Tree(TreeNode root) {
        this.root = root;
    }

    public void verticalSumMain() {
        verticalSum(root);
    }

    private void verticalSum(TreeNode root) {

        if (root == null)
            return;

        Map<Integer, Integer> hm = new TreeMap<>();
        verticalSumUtil(root, 0, hm);

        if (hm != null)
            System.out.print(hm.entrySet());
    }

    private void verticalSumUtil(TreeNode root, int hD, Map<Integer, Integer> hM) {
        if (root == null)
            return;

        verticalSumUtil(root.getLeft(), hD - 1, hM);

        int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + root.getKey());

        verticalSumUtil(root.getRight(), hD + 1, hM);
    }
}

public class VerticalSumInBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));

        Tree tree = new Tree(root);

        System.out.println("Following are the values of vertical sums with the positions of the columns with respect to root ");
        tree.verticalSumMain();
    }

}
