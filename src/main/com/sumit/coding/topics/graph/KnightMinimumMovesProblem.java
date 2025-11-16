package com.sumit.coding.topics.graph;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.*;

/*
 *  Problem: On an infinitely large chessboard, a knight is located on [0, 0].
 *           A knight can move in eight directions.
 *           Given a destination coordinate [x, y], determine the minimum number of moves from [0, 0] to [x, y].
 * */
public class KnightMinimumMovesProblem {

    @AllArgsConstructor
    @EqualsAndHashCode
    private static class Coordinate {
        int r;
        int c;
    }

    public static int getKnightShortestPath(int x, int y) {
        return bfs(new Coordinate(0, 0), x, y);
    }

    private static int bfs(Coordinate root, int x, int y) {
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(root);
        Set<Coordinate> visited = new HashSet<>();
        visited.add(root);

        int steps = 0;

        while (!queue.isEmpty()) {
             int n = queue.size();

             for (int i=0; i<n; i++) {
                 Coordinate node = queue.pop();
                 if(node.c == x && node.r == y) return steps;

                 for (Coordinate neighbor : getNeighbors(node)) {
                     if(visited.contains(neighbor)) continue;

                     queue.add(neighbor);
                     visited.add(neighbor);
                 }
             }
             steps++;
        }

        return steps;
    }

    private static List<Coordinate> getNeighbors(Coordinate coord) {
        List<Coordinate> neighbors = new ArrayList<>();

        int[] deltaRow = {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] deltaCol = {-1, 1, 2, 2, 1, -1, -2, -2};

        for (int i = 0; i < deltaRow.length; i++) {
            int row = deltaRow[i] + coord.r;
            int col = deltaCol[i] + coord.c;

            neighbors.add(new Coordinate(row, col));
        }

        return neighbors;
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        int res = getKnightShortestPath(x, y);
        System.out.println(res);
    }
}
