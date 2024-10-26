package com.sumit.coding.leetcode.blind75.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem URL : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * */
public class SerializeAndDeserializeBinaryTreeProblem {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(5);

        String result = new SerializeAndDeserializeBinaryTreeProblem().serialize(tree);

        System.out.println(result);
        System.out.println(TreeNode.print_using_bfs(new SerializeAndDeserializeBinaryTreeProblem().deserialize(result)));
    }

    /*
     * Steps:
     *
     * 1. Initialize a StringBuilder to build the serialized string.
     * 2. Call `serializeHelper` method recursively, passing each node and the StringBuilder.
     * 3. If the node is `null`, append "null," to the StringBuilder to mark the absence of a node.
     * 4. If the node is not `null`:
     *    - Append the node's value followed by a comma to the StringBuilder.
     *    - Recursively call `serializeHelper` for the left and right children of the current node.
     *
     * Complexity:
     * Time: O(N), where N is the number of nodes, since each node is visited once.
     * Space: O(H), where H is the height of the tree, for the recursion stack.
     */
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serializeHelper(root, str);
        return str.toString();
    }

    public void serializeHelper(TreeNode node, StringBuilder str) {
        if (node == null) {
            str.append("null,");
        } else {
            str.append(node.key).append(",");
            serializeHelper(node.left, str);
            serializeHelper(node.right, str);
        }
    }

    /*
     * Steps:
     *
     * 1. Check if the input string `data` is null or empty; if so, return `null` since there’s no tree to deserialize.
     * 2. Split the serialized string by commas and initialize a queue with the resulting array.
     *    This queue allows sequential access to each node's value.
     * 3. Call `deserializeHelper`, passing the queue, to recursively reconstruct the tree.
     * 4. Poll the next item from the queue (FIFO order).
     * 5. If the polled item is "null", return `null` to indicate there’s no node at this position in the tree.
     * 6. If the item is a valid number:
     *    - Parse it to create a `TreeNode` for this position in the tree.
     *    - Recursively call `deserializeHelper` to set the left and right children of the node.
     * 7. Return the reconstructed tree with the root node as the final output.
     *
     * Complexity:
     * Time: O(N), where N is the number of nodes, since each node and "null" placeholder is processed once.
     * Space: O(H) for the recursion stack, where H is the height of the tree.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        return deserializeHelper(queue);
    }

    public TreeNode deserializeHelper(Queue<String> queue) {
        String data = queue.poll();
        if ("null".equals(data)) return null;

        TreeNode node = new TreeNode(Integer.parseInt(data));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);

        return node;
    }
}
