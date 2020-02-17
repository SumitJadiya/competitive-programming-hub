package main.com.sumit.coding.Tree;

class Node {
    Node left;
    Node right;
    private int data;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Height {
    int h;
}

class BinaryTree {
    Node root;

    public int diameter() {
        Height height = new Height();
        return diameterOpt(root, height);
    }

    private int diameterOpt(Node root, Height height) {

        Height lheight = new Height();
        Height rheight = new Height();

        if (root == null) {
            height.h = 0;
            return 0;
        }

        int ldiameter = diameterOpt(root.left, lheight);
        int rdiameter = diameterOpt(root.right, rheight);

        height.h = Math.max(lheight.h, rheight.h) + 1;

        return Math.max(lheight.h + rheight.h + 1, Math.max(ldiameter, rdiameter));
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
