package main.com.sumit.coding.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

    int key;
    protected TreeNode left;
    protected TreeNode right;

    TreeNode(int x) {
        key = x;
    }

    private static <T> StringBuilder toString(StringBuilder string, TreeNode node) {
        if (node != null) {
            string.append(node.getKey());
            if (node.getLeft() != null) toString(string.append(", "), node.getLeft());
            if (node.getRight() != null) toString(string.append(", "), node.getRight());
        }
        return string;
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

    public static List<List<Integer>> print_using_bfs(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList<>();

            while (size-- > 0) {
                TreeNode temp = queue.remove();
                l.add(temp.key);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }

            results.add(l);
        }

        return results;
    }

    @Override
    public String toString() {
        return toString(new StringBuilder(), this).toString();
    }
}
