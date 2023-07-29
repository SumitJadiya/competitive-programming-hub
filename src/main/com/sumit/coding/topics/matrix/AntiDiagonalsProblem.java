package main.com.sumit.coding.topics.matrix;

public class AntiDiagonalsProblem {
    public static void main(String[] args) {
        int n = 3;
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        AntiDiagonalsProblem antiDiagonalsProblem = new AntiDiagonalsProblem();
        int[][] res = antiDiagonalsProblem.diagonal(A);

        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }

    private int[][] diagonal(int[][] a) {
        int[][] res = new int[a.length][];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i + j == 0) {
                    res[i][j] = a[i][j];
                }
            }
        }
        return res;
    }
}
