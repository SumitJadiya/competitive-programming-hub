package com.sumit.coding.topics.graph;

import java.util.*;

public class TaskSchedulingProblem {

    public static List<String> taskScheduling(List<String> tasks, List<List<String>> requirements) {
        HashMap<String, List<String>> graph = new HashMap<>();

        for (String task : tasks)
            graph.put(task, new ArrayList<>());

        for (List<String> req : requirements)
            graph.get(req.get(0)).add(req.get(1));

        return topoSort(graph);
    }

    private static List<String> topoSort(HashMap<String, List<String>> graph) {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        Map<String, Integer> inDegree = findInDegree(graph);

        inDegree.forEach((key, value) -> {
            if (value == 0)
                queue.add(key);
        });

        while (!queue.isEmpty()) {
            String node = queue.poll();
            res.add(node);

            for (String neighbor : graph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);

                if (inDegree.get(neighbor) == 0)
                    queue.add(neighbor);
            }
        }

        return (graph.size() == res.size()) ? res : null;
    }

    private static Map<String, Integer> findInDegree(Map<String, List<String>> graph) {
        Map<String, Integer> inDegree = new HashMap<>();

        graph.forEach((node, neighbors) -> {
            inDegree.putIfAbsent(node, 0);

            for (String neighbor : neighbors)
                inDegree.put(neighbor, inDegree.getOrDefault(neighbor, 0) + 1);
        });

        return inDegree;
    }

    public static void main(String[] args) {
        List<String> tasks = List.of("a", "b", "c", "d");
        List<List<String>> requirements = List.of(List.of("a", "b"), List.of("c", "b"), List.of("b", "d"));

        List<String> res = taskScheduling(tasks, requirements);

        if (res.size() != tasks.size()) {
            System.out.println("output size " + res.size() + " does not match input size " + tasks.size());
            return;
        }

        HashMap<String, Integer> indices = new HashMap<>();

        for (int i = 0; i < res.size(); i++)
            indices.put(res.get(i), i);

        for (List<String> req : requirements) {
            for (String task : req) {
                if (!indices.containsKey(task)) {
                    System.out.println("'" + task + "' is not in output");
                    return;
                }
            }
            String a = req.get(0);
            String b = req.get(1);
            if (indices.get(a) >= indices.get(b)) {
                System.out.println("'" + a + "' is not before '" + b + "'");
                return;
            }
        }

        System.out.println("ok");
    }
}
