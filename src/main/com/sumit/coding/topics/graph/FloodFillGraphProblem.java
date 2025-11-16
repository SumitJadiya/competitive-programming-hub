package com.sumit.coding.topics.graph;

import lombok.AllArgsConstructor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FloodFillGraphProblem {

    @AllArgsConstructor
    private static class Coordinate {
        int r;
        int c;
    }

    public static List<List<Integer>> floodFill(int r, int c, int replacement, List<List<Integer>> image) {
        int numRows = image.size();
        int numCols = image.get(0).size();

        bfs(image, new Coordinate(r, c), replacement, numRows, numCols);

        return image;
    }

    private static void bfs(List<List<Integer>> image, Coordinate root, int replacementColor, int numRows, int numCols) {
        int rootVal = image.get(root.r).get(root.c);

        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(root);
        boolean[][] visited = new boolean[numRows][numCols];
        visited[root.r][root.c] = true;
        image.get(root.r).set(root.c, replacementColor);

        while (!queue.isEmpty()) {
            Coordinate node = queue.pop();
            for (Coordinate neighbor : getNeighbors(node, numRows, numCols, image, rootVal)) {
                if (visited[neighbor.r][neighbor.c]) continue;

                image.get(neighbor.r).set(neighbor.c, replacementColor);
                queue.add(neighbor);
                visited[neighbor.r][neighbor.c] = true;
            }
        }
    }

    private static List<Coordinate> getNeighbors(Coordinate coord, int numRows, int numCols, List<List<Integer>> image, int rootColor) {
        int[] deltaCol = {0, 1, 0, -1};
        int[] deltaRow = {-1, 0, 1, 0};

        List<Coordinate> neighbors = new ArrayList<>();

        for (int i = 0; i < deltaRow.length; i++) {
            int neighborRow = coord.r + deltaRow[i];
            int neighborCol = coord.c + deltaCol[i];

            if (neighborRow >= 0 && neighborRow < numRows && neighborCol >= 0 && neighborCol < numCols)
                if (image.get(neighborRow).get(neighborCol) == rootColor)
                    neighbors.add(new Coordinate(neighborRow, neighborCol));
        }

        return neighbors;
    }


    public static void main(String[] args) {
        List<List<Integer>> image = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 1, 3, 4, 1)),
                new ArrayList<>(Arrays.asList(3, 8, 8, 3, 3)),
                new ArrayList<>(Arrays.asList(6, 7, 8, 8, 3)),
                new ArrayList<>(Arrays.asList(12, 2, 8, 9, 1)),
                new ArrayList<>(Arrays.asList(12, 3, 1, 3, 2))
        ));
        int r = 2;
        int c = 2;
        int replacement = 9;

        List<List<Integer>> res = floodFill(r, c, replacement, image);
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
