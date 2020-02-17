package main.com.sumit.coding.tree;

public class TreeNode {

    int key;
    TreeNode left;
    TreeNode right;
    TreeNode node;

    TreeNode(int x) {
        key = x;
    }

    private static <T> StringBuilder toString(StringBuilder string, TreeNode node) {
        string.append('{');
        if (node != null) {
            string.append(node.getKey());
            toString(string.append(", "), node.getLeft());
            toString(string.append(", "), node.getRight());
        }
        return string.append('}');
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

    @Override
    public String toString() {
        return toString(new StringBuilder(), this.node).toString();
    }
}
