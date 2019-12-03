package com.sumit.coding.Tree;

class Node {
    Node left;
    Node right;
    private int data;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    private static int height(Node node) {
        if (node == null)
            return 0;

        return (1 + Math.max(height(node.left), height(node.right)));
    }

    public int diameter() {
        return diameter(root);
    }

    private int diameter(Node root) {

        if (root == null)
            return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        /*
         * Return Max of
         * a) Diameter of left subtree.
         * b) Diameter of right subtree.
         * c) height of left + right subtree.
         */

        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
    }
}

public class DiameterOfBinaryTree {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : " + tree.diameter());
    }
}
