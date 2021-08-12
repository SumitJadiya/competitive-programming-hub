package main.com.sumit.coding.backtracking;

/**
 * URL : https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3397/
 * <p>
 * Algorithm
 * 1. At the beginning, first check if we reach the bottom case of the recursion, where the word to be matched is empty, i.e. we've already found the match for each prefix of the word.
 * 2. We then check if the current state is invalid, either the position of the cell is out the boundary of the board or the letter in the current cell does not match with the first letter of the word.
 * 3. If the current step is valid, we then start the exploration of backtracking with the strategy of DFS. First, we mark the current cell as visited e.g. any non-alphabetic letter will do. Then we iterate through the four possible directions, namely up, right, down and left. The order of the directions can be altered, to one's preference.
 * 4. At the end of the exploration , we revert the cell back to its original state. finally we return the result of exploration.
 */
public class WordSearchProblem {

    private char[][] board;
    private int ROWS;
    private int COLS;

    public static void main(String[] args) {
        char[][] sampleBoard =
                {
                        {'c', 'a', 'a'},
                        {'a', 'a', 'a'},
                        {'b', 'c', 'd'}
                };
        String word = "aab";

        System.out.println("Word Exist - " + new WordSearchProblem().exist(sampleBoard, word));
    }

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row)
            for (int col = 0; col < this.COLS; ++col)
                if (backtrack(row, col, word, 0))
                    return true;
        return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) {
        if (index >= word.length())
            return true;

        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS || this.board[row][col] != word.charAt(index))
            return false;

        this.board[row][col] = '#';
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; d++)
            if (backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1)) return true;

        board[row][col] = word.charAt(index);

        return false;
    }
}
