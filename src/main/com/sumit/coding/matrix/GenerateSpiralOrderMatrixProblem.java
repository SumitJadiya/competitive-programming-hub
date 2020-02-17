package main.com.sumit.coding.matrix;

public class GenerateSpiralOrderMatrixProblem {
    public static void main(String[] args) {
        int n = 4;

        int[][] result = (new GenerateSpiralOrderMatrixProblem()).generate(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(result[i][j] + "  ");
            System.out.println();
        }
    }

    private int[][] generate(int size) {
        int[][] arr = new int[size][size];

        int l = 0, n = size; // column
        int k = 0, m = size; // row
        int count = 0;

        while (l < n && k < m) {
            for (int x = l; x < n; x++)
                arr[k][x] = ++count;
            k++;

            for (int x = k; x < m; x++)
                arr[x][n - 1] = ++count;
            n--;

            if (k < m) {
                for (int i = n - 1; i >= l; i--)
                    arr[m - 1][i] = ++count;
                m--;
            }

            if (l < n) {
                for (int i = m - 1; i >= k; i--)
                    arr[i][l] = ++count;
                l++;
            }
        }

        return arr;
    }
}
