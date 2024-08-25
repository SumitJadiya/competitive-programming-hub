package com.sumit.coding.topics.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static com.sumit.coding.topics.tree.TreeNode.print_using_bfs;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Time Complexity : O(N), Space Complexity : O(N)
 */
public class SerialiseAndDeserialiseBinaryTree {

    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        rserialize(root, result);

        return result.toString();
    }

    public void rserialize(TreeNode root, StringBuilder str) {
        if (root == null)
            str.append("null,");
        else {
            str.append(root.key).append(",");
            rserialize(root.left, str);
            rserialize(root.right, str);
        }
    }

    public TreeNode deserialize(String data) {
        Queue<String> dataQueue = new LinkedList<>(Arrays.asList(data.split(",")));
        return rdeserialize(dataQueue);
    }

    public TreeNode rdeserialize(Queue<String> queue) {
        String val = queue.poll();
        if (val == null || val.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = rdeserialize(queue);
        root.right = rdeserialize(queue);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getRight().setLeft(new TreeNode(4));
        root.getRight().setRight(new TreeNode(5));
        System.out.println(print_using_bfs(root));

        SerialiseAndDeserialiseBinaryTree serializedData = new SerialiseAndDeserialiseBinaryTree();
        SerialiseAndDeserialiseBinaryTree deserializedTree = new SerialiseAndDeserialiseBinaryTree();

        System.out.println(print_using_bfs(deserializedTree.deserialize(serializedData.serialize(root))));
    }
}



