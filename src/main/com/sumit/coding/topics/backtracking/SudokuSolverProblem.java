package main.com.sumit.coding.topics.backtracking;

import java.util.Arrays;

/*
 * Problem URL : https://leetcode.com/problems/sudoku-solver
 * */
public class SudokuSolverProblem {
    int n = 3; // box size
    int N = n * n;// row size

    int[][] rows = new int[N][N + 1];
    int[][] columns = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;

    public boolean couldPlace(int d, int row, int col) {
        /* Check if one could place a number d in (row, col) cell */
        int idx = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int row, int col) {
        /* Place a number d in (row, col) cell */
        int idx = (row / n) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char) (d + '0');
    }

    public void removeNumber(int d, int row, int col) {
        /* Remove a number which didn't lead to a solution */
        int idx = (row / n) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    public void placeNextNumbers(int row, int col) {
        // if we're in the last cell that means we have the solution
        if ((col == N - 1) && (row == N - 1)) sudokuSolved = true;
        else {
            if (col == N - 1) backtrack(row + 1, 0); // if we're in the end of the row go to the next row
            else backtrack(row, col + 1);// go to the next column
        }
    }

    public void backtrack(int row, int col) {
        // if the cell is empty
        if (board[row][col] == '.') {
            // iterate over all numbers from 1 to 9
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);

                    if (!sudokuSolved)
                        removeNumber(d, row, col); // if sudoku is solved, there is no need to backtrack since the single unique solution is promised
                }
            }
        } else placeNextNumbers(row, col);
    }

    /*
     * Time Complexity: O(9^(m * n))
     * Space Complexity: O(m*n)
     * */
    public void solveSudoku(char[][] board) {
        this.board = board;

        // init rows, columns and boxes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        new SudokuSolverProblem().solveSudoku(board);

        System.out.println(Arrays.deepToString(board));
    }
}
