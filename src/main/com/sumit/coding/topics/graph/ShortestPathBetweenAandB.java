package com.sumit.coding.topics.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShortestPathBetweenAandB {
    public static int shortestPath(List<List<Integer>> graph, int start, int end) {
        int level = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentVal = queue.pop();
                if (currentVal == end) return level;

                for (int neighbor : graph.get(currentVal)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(List.of(1, 2), List.of(0, 2, 3), List.of(0, 1), List.of(1));
        int res = shortestPath(graph, 0, 3);
        System.out.println(res);
    }
}
