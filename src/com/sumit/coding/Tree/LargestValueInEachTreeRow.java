package com.sumit.coding.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInEachTreeRow {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(3));
        root.setRight(new TreeNode(2));
        root.getLeft().setLeft(new TreeNode(5));
        root.getLeft().setRight(new TreeNode(3));
        root.getRight().setRight(new TreeNode(9));

        System.out.println("Largest Value in each tree row - " + largestValues(root));
    }

    public static List<Integer> largestValues(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> maximumValues = new LinkedList<>();

        if (root == null)
            return maximumValues;

        maximumValues.add(root.key);

        if (checkForNull(root.left))
            queue.add(root.left);

        if (checkForNull(root.right))
            queue.add(root.right);

        while (!queue.isEmpty()) {
            int n = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.remove();
                if (temp.key > max)
                    max = temp.key;

                if (checkForNull(temp.left))
                    queue.add(temp.left);

                if (checkForNull(temp.right))
                    queue.add(temp.right);

            }
            maximumValues.add(max);
        }

        return maximumValues;
    }

    public static boolean checkForNull(TreeNode temp) {
        if (temp != null)
            return true;

        return false;
    }
}
