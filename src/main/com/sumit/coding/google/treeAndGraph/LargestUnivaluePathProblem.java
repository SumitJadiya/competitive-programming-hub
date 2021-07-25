package main.com.sumit.coding.google.treeAndGraph;

/*
 *  Problem URL: https://leetcode.com/problems/longest-univalue-path/
 *
 *  Input: root = [5,4,5,1,1,5]
 *  Output: 2
 * */
public class LargestUnivaluePathProblem {

    int maxLen = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(new LargestUnivaluePathProblem().longestUnivaluePath(root));
    }

    public int longestUnivaluePath(TreeNode root) {
        longestPath(root);
        return maxLen;
    }

    /*
     *  Time Complexity: O(N), where N is the number of nodes in the tree. We process every node once.
     *  Space Complexity: O(H), where H is the height of the tree. Our recursive call stack could be up to H layers deep.
     * */
    private int longestPath(TreeNode node) {
        if (node == null) return 0;

        int left = longestPath(node.left);
        int right = longestPath(node.right);

        int leftLength = 0;
        int rightLength = 0;

        if (node.left != null && node.left.val == node.val) leftLength = left + 1;
        if (node.right != null && node.right.val == node.val) rightLength = right + 1;

        int currentLen = rightLength + leftLength;

        maxLen = (currentLen > maxLen) ? currentLen : maxLen;

        return Math.max(leftLength, rightLength);
    }
}
