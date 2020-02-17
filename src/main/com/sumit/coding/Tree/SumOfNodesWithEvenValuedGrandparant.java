package main.com.sumit.coding.Tree;

public class SumOfNodesWithEvenValuedGrandparant {
    private static int sum;

    public static void main(String[] args) {
/*
        TreeNode root = new TreeNode(6);
        root.setLeft(new TreeNode(7));
        root.setRight(new TreeNode(8));
        root.getLeft().setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(7));
        root.getRight().setLeft(new TreeNode(1));
        root.getRight().setRight(new TreeNode(3));
        root.getLeft().getLeft().setLeft(new TreeNode(9));
        root.getLeft().getRight().setLeft(new TreeNode(1));
        root.getLeft().getRight().setRight(new TreeNode(4));
        root.getRight().getRight().setRight(new TreeNode(5));
*/

        TreeNode root = new TreeNode(50);
        root.setRight(new TreeNode(54));
        root.getRight().setLeft(new TreeNode(98));
        root.getRight().setRight(new TreeNode(6));
        root.getRight().getRight().setRight(new TreeNode(34));
        System.out.println(new SumOfNodesWithEvenValuedGrandparant().sumEvenGrandparent(root));
    }

    private static void dfs(TreeNode root, int grandParent, int parent) {
        if (root == null) return;
        if (grandParent % 2 == 0) sum += root.key;
        dfs(root.left, parent, root.key);
        dfs(root.right, parent, root.key);
    }

    private int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        dfs(root, -1, -1);
        return sum;
    }
}
