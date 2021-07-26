package main.com.sumit.coding.google.treeAndGraph;

import java.util.LinkedList;
import java.util.List;

/*
 * Problem URL : https://leetcode.com/problems/surrounded-regions/
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation:
 * Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * */
public class SurroundedRegionProblem {

    protected Integer ROWS = 0;
    protected Integer COLS = 0;

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new SurroundedRegionProblem().solve(board);
    }

    public void printBoard(char[][] board) {
        for (int r = 0; r < this.ROWS; ++r) {
            for (int c = 0; c < this.COLS; ++c) System.out.print(board[r][c] + " ");
            System.out.println();
        }
    }

    /*
     * Complexity Analysis :
     *
     * Time Complexity: O(N) where N is the number of cells in the board.
     * In the worst case where it contains only the O cells on the board, we would traverse each cell twice: once during the DFS traversal and the other time during the cell reversion in the last step.
     *
     * Space Complexity: O(N) where N is the number of cells in the board. There are mainly two places that we consume some additional memory.
     * We keep a list of border cells as starting points for our traversal. We could consider the number of border cells is proportional to the total number (N) of cells.
     * During the recursive calls of DFS() function, we would consume some space in the function call stack, i.e. the call stack will pile up along with the depth of recursive calls.
     * And the maximum depth of recursive calls would be NN as in the worst scenario mentioned in the time complexity.
     * As a result, the overall space complexity of the algorithm is \mathcal{O}(N)O(N).
     * */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        this.ROWS = board.length;
        this.COLS = board[0].length;
        List<Pair<Integer, Integer>> borders = new LinkedList<>();

        // Step 1). construct the list of border cells
        for (int r = 0; r < this.ROWS; ++r) {
            borders.add(new Pair(r, 0));
            borders.add(new Pair(r, this.COLS - 1));
        }

        for (int c = 0; c < this.COLS; ++c) {
            borders.add(new Pair(0, c));
            borders.add(new Pair(this.ROWS - 1, c));
        }

        // Step 2). mark the escaped cells
        for (Pair<Integer, Integer> pair : borders)
            this.DFS(board, pair.first, pair.second);

        // Step 3). flip the cells to their correct final states
        for (int r = 0; r < this.ROWS; ++r) {
            for (int c = 0; c < this.COLS; ++c) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
                if (board[r][c] == 'E')
                    board[r][c] = 'O';
            }
        }
        printBoard(board);
    }

    protected void DFS(char[][] board, int row, int col) {
        if (col > this.COLS - 1 || row > this.ROWS - 1 || col < 0 || row < 0 || board[row][col] != 'O') return;

        board[row][col] = 'E';
        this.DFS(board, row, col + 1);
        this.DFS(board, row + 1, col);
        this.DFS(board, row, col - 1);
        this.DFS(board, row - 1, col);
    }
}

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}
