package main.com.sumit.coding.leetcode.Oct20;

/*
* URL :
* https://leetcode.com/explore/featured/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3485/
* */
public class Problem06 {

    public static void main(String[] args) {
        int val = 25;
        TreeNode06 root = new TreeNode06(4);
        root.setLeft(new TreeNode06(2));
        root.setRight(new TreeNode06(7));
        root.leftNode.setLeft(new TreeNode06(1));
        root.leftNode.setRight(new TreeNode06(3));

        new Problem06().preOrder(new Problem06().insertIntoBST(root, val));
    }

    public TreeNode06 insertIntoBST(TreeNode06 root, int val) {

        if (root == null)
            root = new TreeNode06(val);
        else
            insertBST(root, val);

        return root;
    }

    public void insertBST(TreeNode06 root, int val) {

        if (root.value > val) {
            if (root.leftNode == null)
                root.leftNode = new TreeNode06(val);
            else
                insertBST(root.leftNode, val);
        } else {
            if (root.rightNode == null)
                root.rightNode = new TreeNode06(val);
            else
                insertBST(root.rightNode, val);
        }
    }

    private void preOrder(TreeNode06 node) {
        if (node == null)
            return;

        /* then print the data of node */
        System.out.printf("%d ", node.value);

        /* first recur on left child */
        preOrder(node.leftNode);

        /* now recur on right child */
        preOrder(node.rightNode);
    }
}

class TreeNode06 {
    int value;
    TreeNode06 leftNode;
    TreeNode06 rightNode;

    TreeNode06(int val) { this.value = val; }

    TreeNode06(int val, TreeNode06 left, TreeNode06 right) {
        this.value = val;
        this.leftNode = left;
        this.rightNode = right;
    }

    public TreeNode06 getLeft() {
        return leftNode;
    }

    public void setLeft(TreeNode06 left) {
        this.leftNode = left;
    }

    public TreeNode06 getRight() {
        return rightNode;
    }

    public void setRight(TreeNode06 right) {
        this.rightNode = right;
    }

    private static <T> StringBuilder toString(StringBuilder string, TreeNode06 node) {
        string.append('{');
        if (node != null) {
            string.append(node.value);
            toString(string.append(", "), node.getLeft());
            toString(string.append(", "), node.getRight());
        }
        return string.append('}');
    }
}
