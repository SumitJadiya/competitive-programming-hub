package main.com.sumit.coding.google.treeAndGraph;

public class DiameterOfTreeProblem {
    int maxVal;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(new DiameterOfTreeProblem().diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxVal = 0;
        longestPath(root);
        return maxVal;
    }

    /*
        Complexity Analysis :
        Let N be the number of nodes in the tree.

        Time complexity: O(N).
        This is because in our recursion function longestPath, we only enter and exit from each node once.
        We know this because each node is entered from its parent, and in a tree, nodes only have one parent.

        Space complexity: O(N). The space complexity depends on the size of our implicit call stack during our DFS, which relates to the height of the tree.
        In the worst case, the tree is skewed so the height of the tree is O(N)O(N). If the tree is balanced, it'd be O(\log N)O(logN).
    */
    private int longestPath(TreeNode node) {
        if (node == null) return 0;
        int leftLength = longestPath(node.left);
        int rightLength = longestPath(node.right);

        maxVal = Math.max(leftLength + rightLength, maxVal);

        return Math.max(leftLength, rightLength) + 1;
    }
}
