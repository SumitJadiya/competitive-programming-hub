package com.sumit.coding.topics.graph;

import java.util.*;

public class ReconstructingSequenceProblem {

    public static boolean sequenceReconstruction(List<Integer> originals, List<List<Integer>> seqs) {
        int n = originals.size();
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++)
            graph.put(i, new HashSet<>());

        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size() - 1; i++) {
                int earlyNum = seq.get(i), lateNum = seq.get(i + 1);

                graph.get(earlyNum).add(lateNum);
            }
        }
        return topoSort(graph, originals);
    }


    private static boolean topoSort(Map<Integer, Set<Integer>> graph, List<Integer> originals) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> reconstructed = new ArrayList<>();
        Map<Integer, Integer> inDegree = findInDegree(graph);

        inDegree.forEach((key, value) -> {
            if (value == 0) queue.add(key);
        });

        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;

            Integer node = queue.poll();
            reconstructed.add(node);

            for (Integer neighbor : graph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);

                if (inDegree.get(neighbor) == 0)
                    queue.add(neighbor);
            }
        }

        return originals.equals(reconstructed);
    }

    private static Map<Integer, Integer> findInDegree(Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> indegree = new HashMap<>();

        graph.keySet().forEach(node -> {
            indegree.put(node, 0);
        });

        graph.entrySet().forEach(entry -> {
            for (Integer neighbor : entry.getValue())
                indegree.put(neighbor, indegree.get(neighbor) + 1);
        });

        return indegree;
    }

    public static void main(String[] args) {
        List<Integer> original = List.of(1, 2, 3);
        List<List<Integer>> seqs = List.of(List.of(1, 2), List.of(1, 3), List.of(2, 3));

        boolean res = sequenceReconstruction(original, seqs);
        System.out.println(res);
    }
}
