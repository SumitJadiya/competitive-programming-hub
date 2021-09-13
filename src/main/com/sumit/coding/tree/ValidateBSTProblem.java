package main.com.sumit.coding.tree;

/*
 * Problem URL : https://leetcode.com/problems/validate-binary-search-tree/
 * */
public class ValidateBSTProblem {

    private Integer prev;

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.setLeft(new TreeNode(1));
//        root.setRight(new TreeNode(4));
//        root.getRight().setLeft(new TreeNode(3));
//        root.getRight().setRight(new TreeNode(6));
        TreeNode root = new TreeNode(2);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(3));

        System.out.println(new ValidateBSTProblem().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) return true;

        if (!inorder(root.left)) return false;

        if (prev != null && root.key <= prev) return false;

        prev = root.key;
        return inorder(root.right);
    }
}
