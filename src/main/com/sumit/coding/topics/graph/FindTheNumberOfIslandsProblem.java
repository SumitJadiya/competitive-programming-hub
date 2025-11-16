package com.sumit.coding.topics.graph;

import lombok.AllArgsConstructor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *  Problem : Given a 2-dimensional matrix of values with 0 and 1, count the number of islands of 1.
 *            An island consists of all 1 value cells and is surrounded by either an edge or all 0 cells.
 *            Cells can only be adjacent to each other horizontally or vertically, not diagonally.
 *
 *  Time Complexity: O(r*c)
 *  Space Complexity: O(r+c)
 * */
public class FindTheNumberOfIslandsProblem {

    @AllArgsConstructor
    private static class Coordinate {
        int r;
        int c;
    }

    public static int countNumberOfIslands(List<List<Integer>> grid) {
        int numRows = grid.size();
        int numCols = grid.get(0).size();

        int count = 0;

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (grid.get(r).get(c) == 0) continue;
                bfs(grid, new Coordinate(r, c), numRows, numCols);

                count++;
            }
        }
        return count;
    }

    private static void bfs(List<List<Integer>> grid, Coordinate root, int numRows, int numCols) {
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(root);
        grid.get(root.r).set(root.c, 0);
        while (!queue.isEmpty()) {
            Coordinate node = queue.pop();
            for (Coordinate neighbor : getNeighbors(node, numRows, numCols)) {
                if (grid.get(neighbor.r).get(neighbor.c) == 0) continue;

                queue.add(neighbor);
                grid.get(neighbor.r).set(neighbor.c, 0);
            }
        }
    }

    private static List<Coordinate> getNeighbors(Coordinate cell, int numRows, int numCols) {
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        List<Coordinate> neighbors = new ArrayList<>();
        for (int i = 0; i < deltaRow.length; i++) {
            int neighborRow = deltaRow[i] + cell.r;
            int neighborCol = deltaCol[i] + cell.c;

            if (neighborRow >= 0 && neighborRow < numRows && neighborCol >= 0 && neighborCol < numCols)
                neighbors.add(new Coordinate(neighborRow, neighborCol));
        }

        return neighbors;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0, 0)),
                new ArrayList<>(Arrays.asList(1, 1, 1, 1, 0, 0)),
                new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0, 0)),
                new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 0)),
                new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 0)),
                new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0))
        ));
        int res = countNumberOfIslands(grid);
        System.out.println(res);
    }
}
