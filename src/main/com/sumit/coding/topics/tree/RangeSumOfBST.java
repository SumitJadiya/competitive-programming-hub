package main.com.sumit.coding.topics.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 *
 * Problem URL :
 * https://leetcode.com/problems/range-sum-of-bst/
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 *
 * */
public class RangeSumOfBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.setLeft(new TreeNode(5));
        root.setRight(new TreeNode(15));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().setRight(new TreeNode(7));
        root.getRight().setRight(new TreeNode(18));

        int L = 7;
        int R = 15;

        System.out.println("The sum of values of all nodes with value between L and R : " + rangeSumBST(root, L, R));
    }

    private static int rangeSumBST(TreeNode root, int l, int r) {

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        if (checkForNull(root))
            queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            queue.remove();

            if (node.key >= l && node.key <= r)
                sum += node.key;

            if (checkForNull(node.left))
                queue.add(node.left);

            if (checkForNull(node.right))
                queue.add(node.right);
        }

        return sum;
    }

    public static boolean checkForNull(TreeNode temp) {
        if (temp != null)
            return true;

        return false;
    }
}
