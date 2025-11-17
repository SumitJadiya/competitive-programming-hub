package com.sumit.coding.topics.graph;

import lombok.AllArgsConstructor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZombieInMatrix {

    @AllArgsConstructor
    private static class Coord {
        int row;
        int col;

        public Coord add(Coord delta) {
            return new Coord(delta.row + this.row, delta.col + this.col);
        }
    }

    static List<Coord> directions = List.of(new Coord(0, 1), new Coord(1, 0), new Coord(0, -1), new Coord(-1, 0));

    public static List<List<Integer>> mapGateDistances(List<List<Integer>> dungeonMap) {
        ArrayDeque<Coord> queue = new ArrayDeque<>();

        int rowSize = dungeonMap.size();
        int colSize = dungeonMap.get(0).size();

        for (int r = 0; r < rowSize; r++)
            for (int c = 0; c < colSize; c++)
                if (dungeonMap.get(r).get(c) == 0)
                    queue.offer(new Coord(r, c));

        while (!queue.isEmpty()) {
            Coord currentPos = queue.poll();
            for (Coord delta : directions) {
                Coord newPos = currentPos.add(delta);

                if (newPos.row >= 0 && newPos.row < rowSize && newPos.col >= 0 && newPos.col < colSize) {
                    if (dungeonMap.get(newPos.row).get(newPos.col) == Integer.MAX_VALUE) {
                        dungeonMap.get(newPos.row).set(newPos.col, 1 + dungeonMap.get(currentPos.row).get(currentPos.col));
                        queue.add(newPos);
                    }
                }
            }
        }

        return dungeonMap;
    }

    public static void main(String[] args) {
        List<List<Integer>> dungeonMap = new ArrayList<>();

        dungeonMap.add(new ArrayList<>(List.of(2147483647, -1, 0, 2147483647)));
        dungeonMap.add(new ArrayList<>(List.of(2147483647, 2147483647, 2147483647, -1)));
        dungeonMap.add(new ArrayList<>(List.of(2147483647, -1, 2147483647, -1)));
        dungeonMap.add(new ArrayList<>(List.of(0, -1, 2147483647, 2147483647)));
        List<List<Integer>> res = mapGateDistances(dungeonMap);
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
