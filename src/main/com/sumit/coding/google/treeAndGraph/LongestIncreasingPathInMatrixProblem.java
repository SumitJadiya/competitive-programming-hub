package main.com.sumit.coding.google.treeAndGraph;

/*
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * */
public class LongestIncreasingPathInMatrixProblem {
    int rows, cols;
    int[][] cache;
    int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(new LongestIncreasingPathInMatrixProblem().longestIncreasingPath(matrix));
    }

    /*
     * Time Complexity: O(mn)
     * Space Complexity: O(mn)
     * */
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        if (rows == 0) return 0;
        cols = matrix[0].length;

        int maxPath = 0;
        cache = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                maxPath = Math.max(dfs(matrix, i, j), maxPath);

        return maxPath;
    }

    public int dfs(int[][] matrix, int i, int j) {
        if (cache[i][j] > 0) return cache[i][j];
        int maxDirPath = 0;

        for (int[] d : dir) {
            int dirI = i + d[0];
            int dirJ = j + d[1];

            if (valid(dirI, dirJ) && matrix[i][j] < matrix[dirI][dirJ])
                maxDirPath = Math.max(dfs(matrix, dirI, dirJ), maxDirPath);
        }

        cache[i][j] = maxDirPath + 1;
        return cache[i][j];
    }

    public boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }
}
