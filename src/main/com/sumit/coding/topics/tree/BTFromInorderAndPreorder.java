package com.sumit.coding.topics.tree;

import java.util.HashMap;
import java.util.Map;

public class BTFromInorderAndPreorder {

    private static TreeNode buildTree(int[] inorder, int[] preorder) {
        if (preorder.length == 0 || inorder.length != preorder.length) return null;

        return buildBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildBinaryTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int data = preorder[preStart];
        TreeNode curr = new TreeNode(data);
        int offset = inStart;

        for (; offset < inEnd; offset++)
            if (inorder[offset] == data) break;

        curr.left = buildBinaryTree(preorder, preStart + 1, preStart + offset - inStart, inorder, inStart, offset - 1);
        curr.right = buildBinaryTree(preorder, preStart + offset - inStart + 1, preEnd, inorder, offset + 1, inEnd);
        return curr;
    }


    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree_approach2(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }


    public static void main(String[] args) {
        int[] inorder = {3, 9, 20, 15, 7};
        int[] preorder = {9, 3, 15, 20, 7};

//        System.out.println(TreeNode.print_using_bfs(buildTree(inorder, preorder)));
        System.out.println(TreeNode.print_using_bfs(new BTFromInorderAndPreorder().buildTree_approach2(inorder, preorder)));
    }
}
