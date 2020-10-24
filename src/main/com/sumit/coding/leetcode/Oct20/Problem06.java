package main.com.sumit.coding.leetcode.Oct20;

/*
* URL :
* https://leetcode.com/explore/featured/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3485/
* */
public class Problem06 {

    public static void main(String[] args) {
        int val = 25;
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(7));
        root.left.setLeft(new TreeNode(1));
        root.left.setRight(new TreeNode(3));

        new Problem06().preOrder(new Problem06().insertIntoBST(root, val));
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null)
            root = new TreeNode(val);
        else
            insertBST(root, val);

        return root;
    }

    public void insertBST(TreeNode root, int val) {

        if (root.val > val) {
            if (root.left == null)
                root.left = new TreeNode(val);
            else
                insertBST(root.left, val);
        } else {
            if (root.right == null)
                root.right = new TreeNode(val);
            else
                insertBST(root.right, val);
        }
    }

    private void preOrder(TreeNode node) {
        if (node == null)
            return;

        /* then print the data of node */
        System.out.printf("%d ", node.val);

        /* first recur on left child */
        preOrder(node.left);

        /* now recur on right child */
        preOrder(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() { }
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
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

    private static <T> StringBuilder toString(StringBuilder string, TreeNode node) {
        string.append('{');
        if (node != null) {
            string.append(node.val);
            toString(string.append(", "), node.getLeft());
            toString(string.append(", "), node.getRight());
        }
        return string.append('}');
    }
}
