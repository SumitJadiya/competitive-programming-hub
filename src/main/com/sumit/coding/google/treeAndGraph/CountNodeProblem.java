package main.com.sumit.coding.google.treeAndGraph;

/*
 * Problem URL : https://leetcode.com/problems/count-complete-tree-nodes/
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 * */
public class CountNodeProblem {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(new CountNodeProblem().countNodes(root));
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + right + 1;
    }
}
