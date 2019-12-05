package com.sumit.coding.Tree;

public class TreeNode {

    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        key = x;
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
