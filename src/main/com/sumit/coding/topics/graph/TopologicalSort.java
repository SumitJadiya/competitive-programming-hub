package com.sumit.coding.topics.graph;

import java.util.*;

public class TopologicalSort {

    public static <T> List<T> topoSort(Map<T, List<T>> graph) {
        List<T> res = new ArrayList<>();
        Queue<T> queue = new ArrayDeque<>();
        Map<T, Integer> inDegree = findInDegree(graph);
        inDegree.forEach((key, value) -> {
            if (value == 0)
                queue.add(key);
        });

        while (!queue.isEmpty()) {
            T node = queue.poll();
            res.add(node);

            for (T neighbor : graph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);

                if (inDegree.get(neighbor) == 0)
                    queue.add(neighbor);
            }
        }

        return (graph.size() == res.size()) ? res : null;
    }

    public static <T> Map<T, Integer> findInDegree(Map<T, List<T>> graph) {
        Map<T, Integer> inDegree = new HashMap<>();

        graph.forEach((node, neighbors) -> {
            inDegree.putIfAbsent(node, 0);

            for (T neighbor : neighbors)
                inDegree.put(neighbor, inDegree.getOrDefault(neighbor, 0) + 1);
        });

        return inDegree;
    }

}
