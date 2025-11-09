package com.sumit.coding.topics.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BFSGraph {

    private static int start;

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(List.of(1, 2), List.of(0, 2, 3), List.of(0, 1), List.of(1));
        bfs(graph);
    }

    private static void bfs(List<List<Integer>> graph) {
        BFSGraph.start = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int currentVal = queue.poll();
            System.out.print(currentVal);

            for (int neighbor : graph.get(currentVal)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }

            if (!queue.isEmpty())
                System.out.print(" -> ");
        }
    }
}
