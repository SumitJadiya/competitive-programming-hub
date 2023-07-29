package main.com.sumit.coding.topics.tree;

/*
 * Problem URL : https://leetcode.com/problems/validate-binary-search-tree/
 * */
public class ValidateBinarySearchTreeProblem {

    static Integer prevNode;

    // left node < root node
    // right node > root node
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;

        if (prevNode != null && root.key <= prevNode) return false;

        prevNode = root.key;

        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        prevNode = null;

        TreeNode root = new TreeNode(2);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(3));
        System.out.println(isValidBST(root));

        root = new TreeNode(5);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(4));
        root.getRight().setLeft(new TreeNode(3));
        root.getRight().setRight(new TreeNode(6));

        System.out.println(isValidBST(root));
    }
}
