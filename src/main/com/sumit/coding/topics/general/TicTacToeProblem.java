package main.com.sumit.coding.topics.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TicTacToeProblem {

    List<Integer> rows;
    List<Integer> cols;
    int diagonal;
    int antiDiagonal;

    // TicTacToe class contains rows, cols, diagonal,
    // and anti_diagonal to create a board.
    // Constructor is used to create a board of size n * n.
    public TicTacToeProblem(int n) {
        this.rows = new ArrayList<>(Collections.nCopies(n, 0));
        this.cols = new ArrayList<>(Collections.nCopies(n, 0));
        diagonal = 0;
        antiDiagonal = 0;
    }

    // move function will allow the players to play the game
    // for given row and col.
    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        int n = rows.size();

        rows.set(row, rows.get(row) + currentPlayer);
        cols.set(col, cols.get(col) + currentPlayer);

        if (row == col)
            diagonal += currentPlayer;

        if (col == (n - row - 1))
            antiDiagonal += currentPlayer;

        if (Math.abs(rows.get(row)) == n || Math.abs(cols.get(col)) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n)
            return player;

        return 0;
    }

    public static void main(String args[]) {
        int n = 3;

        List<List<List<Integer>>> inputs = new ArrayList<>();
        inputs.add(Arrays.asList(Arrays.asList(0, 1, 1), Arrays.asList(1, 0, 2), Arrays.asList(2, 1, 1), Arrays.asList(1, 2, 2), Arrays.asList(0, 2, 1), Arrays.asList(2, 2, 2), Arrays.asList(1, 1, 1)));
        inputs.add(Arrays.asList(Arrays.asList(0, 0, 1), Arrays.asList(0, 2, 2), Arrays.asList(2, 2, 1), Arrays.asList(1, 1, 2), Arrays.asList(1, 0, 1), Arrays.asList(2, 0, 2), Arrays.asList(1, 2, 1)));

        for (int game = 0; game < 2; game++) {
            System.out.println("Game " + (game + 1) + ":");
            TicTacToeProblem ticTacToeObj = new TicTacToeProblem(n);
            int win;

            for (int i = 0; i < inputs.get(game).size(); i++) {
                System.out.print("\nMove " + (i + 1) + ": Player " + inputs.get(game).get(i).get(2) + " places their mark at " + inputs.get(game).get(i).get(0) + ", " + inputs.get(game).get(i).get(1));

                win = ticTacToeObj.move(inputs.get(game).get(i).get(0), inputs.get(game).get(i).get(1), inputs.get(game).get(i).get(2));

                if (win == 0) {
                    System.out.println("\tNo one wins the game");
                    System.out.print(new String(new char[100]).replace('\0', '-'));
                } else {
                    System.out.println("\tPlayer " + win + " wins the game");
                    System.out.println(new String(new char[100]).replace('\0', '-'));
                    break;
                }
            }
        }
    }
}
